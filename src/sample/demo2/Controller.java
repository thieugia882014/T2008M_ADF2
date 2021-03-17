package sample.demo2;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Controller {
    public TextField txtName;
    public TextField txtAge;
    public TextField txtMark;
    public TextArea txtRs;
    public Button btnSort;
    public Text txtValidate;

    ArrayList<SinhVien> ds = new ArrayList<>();
    static boolean sortType = false;

    public void input(){
        try {
            String n =  txtName.getText();
            int a = Integer.parseInt(txtAge.getText());
            int m = Integer.parseInt(txtMark.getText());
            if(!n.isEmpty()){
                SinhVien s = new SinhVien(n,a,m);
                ds.add(s);
                String txt = "";
                for(SinhVien i:ds){
                    txt+= i.getName()+"--"+i.getAge()+"--"+i.getMark()+"\n";
                }
                txtRs.setText(txt);
                txtValidate.setText("");
                txtName.setText("");
                txtAge.setText("");
                txtMark.setText("");
            }else {
                txtValidate.setText("Vui lòng nhập tên, tuổi và điểm thi");
                txtValidate.setDisable(false);
            }
        }catch (Exception e){
            txtValidate.setText("Vui lòng nhập tên, tuổi và điểm thi");
            txtValidate.setDisable(false);
        }

    }

    public void sort(){
        sortType =  !sortType;
        if(sortType){
            Collections.sort(ds, new Comparator<SinhVien>() {
                @Override
                public int compare(SinhVien o1, SinhVien o2) {
                    return o1.getMark() - o2.getMark();
                }
            });
            btnSort.setText("Thap den cao");
        }else{
            Collections.sort(ds, new Comparator<SinhVien>() {
                @Override
                public int compare(SinhVien o1, SinhVien o2) {
                    return o2.getMark() - o1.getMark();
                }
            });
            btnSort.setText("Cao den thap");
        }
        String txt = "";
        for(SinhVien i:ds){
            txt+= i.getName()+"--"+i.getAge()+"--"+i.getMark()+"\n";
        }
        txtRs.setText(txt);
    }
}
