/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package frame;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Question;
import domain.User;
import java.awt.Dimension;
import java.awt.Font;
import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import org.apache.log4j.Logger;
import util.IOUtil;
import util.QuestionUtil;
/**
 *
 * @author Administrator
 */
public class FrmSelect extends javax.swing.JFrame {
    private static Logger logger = Logger.getLogger(FrmSelect.class);
    private Vector<Vector<String>> data;
    private Vector<String> title;
    private JScrollPane scp=new JScrollPane();
    private DefaultTableModel dtm = new DefaultTableModel();
    private IOUtil ioutil = IOUtil.getIOUtil();
    private User user;
    private int row=0;
    private int flag;
    private TableColumn column;
    
    public FrmSelect() {
        initComponents();
        data = new Vector<>();
        title=new Vector();
        title.add("方案号");
        title.add("方案名称");
        title.add("状态");
        title.add("成绩");
        dtm.setColumnIdentifiers(title);
        tblDetail.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
        tblDetail.setRowHeight(35);
        JTableHeader head = tblDetail.getTableHeader();
        head.setPreferredSize(new Dimension(head.getWidth(), 40));// 设置表头大小
        head.setFont(new Font("宋体", Font.PLAIN, 24));// 设置表格字体
        tblDetail.setModel(dtm);
        showTableData();
        user = IOUtil.getUser();
        if(!user.getGroupID().equals("1")){
            btnManage.setVisible(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnUpdatePassword = new javax.swing.JButton();
        btnEnter = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDetail = new javax.swing.JTable();
        btnManage = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("选择方案");

        btnUpdatePassword.setText("修改密码");
        btnUpdatePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdatePasswordActionPerformed(evt);
            }
        });

        btnEnter.setText("参加考试");
        btnEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnterActionPerformed(evt);
            }
        });

        btnBack.setText("返回登录");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        tblDetail.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        tblDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblDetail);

        btnManage.setText("管理班级");
        btnManage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 937, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnUpdatePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnManage, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(btnEnter, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(46, 46, 46))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdatePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEnter, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnManage, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnterActionPerformed
        // TODO add your handling code here:
        int selected = tblDetail.getSelectedRow();
        if(selected == -1) {
            JOptionPane.showMessageDialog(null, "请选择一个方案","系统提示",JOptionPane.WARNING_MESSAGE);
            return;
        }
        List<Question> list = getQuestions(data.get(selected).get(0));
        QuestionUtil.setName(data.get(selected).get(1));
        QuestionUtil.setList(list);
        new examFrame().setVisible(true);
    }//GEN-LAST:event_btnEnterActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
 
        FrmLogin log=new FrmLogin();
        log.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnUpdatePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdatePasswordActionPerformed
        // TODO add your handling code here:
        FrmUpdatePassword upw=new FrmUpdatePassword();
        upw.setVisible(true);
        //this.setEnabled(false);
    }//GEN-LAST:event_btnUpdatePasswordActionPerformed

    private void btnManageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageActionPerformed
        new FrmManage().setVisible(true);
    }//GEN-LAST:event_btnManageActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmSelect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmSelect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmSelect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmSelect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmSelect().setVisible(true);
                
            }
        });
    }
    //在表格中显示数据的方法
    public void showTableData(){
        ioutil.writeln("getcourses");
        String s = ioutil.readln();
        if(s.equals("GC1")) {
            String json = ioutil.readln();
            ObjectMapper objectMapper =  new ObjectMapper();
            List<Map<String, String>> courses = null;
            try {
                courses = objectMapper.readValue(json, new TypeReference<List<Map<String, String>>>(){});
            } catch (JsonProcessingException ex) {
                logger.error(ex);
            }
            data.clear();
            for(Map<String, String> item : courses) {
                Vector<String> row = new Vector<>();
                row.add(item.get("courseid"));
                row.add(item.get("coursename"));
                String finished = item.get("finished");
                //row.add(finished);
                if(finished.equals("true")) {
                    row.add("完成");
                    row.add(item.get("score"));
                } else {
                    row.add("未完成");
                    row.add("");
                }
                data.add(row);
            }
        } else {
            JOptionPane.showMessageDialog(null, "无法获取信息!请重新登录","系统提示",JOptionPane.INFORMATION_MESSAGE);
        }
        dtm.setDataVector(data, title);
    }
    
     public void tblClicked(java.awt.event.MouseEvent evt){
         //row=tbl.getSelectedRow();
        /* showTextData2(row);*/
     }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnEnter;
    private javax.swing.JButton btnManage;
    private javax.swing.JButton btnUpdatePassword;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDetail;
    // End of variables declaration//GEN-END:variables

    private List<Question> getQuestions(String courseid) {
        ioutil.writeln("getquestions" + " " + courseid);
        String ret = ioutil.readln();
        ObjectMapper om = new ObjectMapper();
        if(ret.equals("GQ1")) {
            ret = ioutil.readln();
            try {
                List<Question> list = om.readValue(ret, new TypeReference<List<Question>>(){});
                return list;
            } catch (JsonProcessingException ex) {
                logger.error(ex);
            }
        }
        
        return null;
    }

}