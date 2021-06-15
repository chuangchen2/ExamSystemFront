/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import domain.User;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;

/**
 *
 * @author aa769
 */
public class IOUtil {
    private OutputStream outputStream;
    private DataOutputStream dataOutputStream;
    private InputStream inputStream;
    private DataInputStream dataInputStream;
    private Socket socket;
    private static User user;
    private static IOUtil ioUtil  = null;
    private static Logger logger = Logger.getLogger(IOUtil.class);

    public static IOUtil getIOUtil() {
        if (ioUtil != null) {
            return ioUtil;
        } else {
            new IOUtil();
            return ioUtil;
        }
    }

    public static void setIOUtil(IOUtil ioUtil) {
        IOUtil.ioUtil = ioUtil;
    }
    
    //构造方法、与后端连接
    private IOUtil(){
        try{
            socket = new Socket("127.0.0.1",8888);
            OutputStream outputStream = socket.getOutputStream();
            inputStream = socket.getInputStream();
            dataInputStream = new DataInputStream(inputStream);
            dataOutputStream = new DataOutputStream(outputStream);
            IOUtil.setIOUtil(this);
        } catch(IOException e) {
            logger.error("无法与服务器连接");
            JOptionPane.showMessageDialog(null, "无法与服务器连接!","系统提示",JOptionPane.ERROR_MESSAGE);
            IOUtil.setIOUtil(null);
        }
    }

    public void writeln(String string) {
        try {
            dataOutputStream.writeUTF(string);
            dataOutputStream.flush();
        } catch (IOException e) {
            logger.error(e);
        }
    }

    public String readln() {
        String readString = "";
        try {
            readString = dataInputStream.readUTF();
        } catch (IOException ex) {
            logger.error(ex);
        }
        return readString;
    }

    public void release() {
        try {
            dataInputStream.close();
            inputStream.close();
            dataOutputStream.close();
            outputStream.close();
            socket.close();
        } catch (IOException ex) {
            logger.error(ex);
        }
    }
    
    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        IOUtil.user = user;
    }
    
}
