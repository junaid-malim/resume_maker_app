package com.collegeutilapp.junaid.resume_maker;

import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.valdesekamdem.library.mdtoast.MDToast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class final_screen extends AppCompatActivity {


    private String name,email,phono,address,personaldesc;
    private String grade10total,grade10scored,grade12total,grade12scored,gradtotal,gradscored,postgradtotal,postgradscored,percent10,percent12,percentgrad,percentpost;

    private ArrayList<String> emp_history_company=new ArrayList();
    private ArrayList<String> emp_history_time=new ArrayList();
    private ArrayList<String> emp_history_role=new ArrayList();

    private ArrayList<String> skills_list=new ArrayList();
    private ArrayList<String> hobbies_list=new ArrayList();
    private ArrayList<String> lang_list=new ArrayList();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_screen);
        Button startprocess;
        startprocess=findViewById(R.id.startprocess);
        final TextView tvpath=findViewById(R.id.pathnametv);

        startprocess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    Date date = new Date();
                    DateFormat dateFormat = new SimpleDateFormat("yyyymmddhhmms");

                    Document document = new Document();
                    String savepdfto = Environment.getExternalStorageDirectory() + File.separator + "Resume_maker_generated_PDF" + File.separator;
                    File savefldr = new File(savepdfto);
                    if (!savefldr.exists()){
                        savefldr.mkdir();
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(savepdfto + "pdf" + dateFormat.format(date) + ".pdf");
                    PdfWriter.getInstance(document, fileOutputStream);

                    document.open();
                    //////////////////////

                    document.add(new Paragraph("name:- "+name));
                    document.add(new Paragraph("address:- " + address));
                    document.add(new Paragraph("email:- " + email));
                    document.add(new Paragraph("phone:- " + phono));
                    document.add(Chunk.NEWLINE);

                    PdfPTable table = new PdfPTable(new float[]{1f, 4f});
                    table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell("personal description");
                    table.addCell(personaldesc);
                    document.add(table);
                    document.add(Chunk.NEWLINE);

                    //////////////

                    document.add(new Paragraph("Education Details"));
                    document.add(Chunk.NEWLINE);
                    PdfPTable tbl1 = new PdfPTable(new float[]{1f, 4f});
                    tbl1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
                    tbl1.addCell("10th standard");
                    tbl1.addCell("SCORED: " + grade10scored + " out of " + grade10total + " = " + percent10);
                    tbl1.addCell("12th standard");
                    tbl1.addCell("SCORED: " + grade12scored + " out of " +grade12total+ " = " + percent12);
                    tbl1.addCell("graduation");
                    tbl1.addCell("SCORED: " + gradscored + " out of " +gradtotal + " = " + percentgrad);
                    tbl1.addCell("post graduation");
                    tbl1.addCell("SCORED: " +postgradscored + " out of " + postgradtotal + " = " +percentpost);
                    document.add(tbl1);

                    ///////////////////////

                    document.add(new Paragraph("Employement History"));
                    document.add(Chunk.NEWLINE);
                    PdfPTable tbl2 = new PdfPTable(new float[]{2f, 2f, 4f});
                    tbl2.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
                    tbl2.addCell("company name");
                    tbl2.addCell("period of Employment");
                    tbl2.addCell("role in company");
                    tbl2.setHeaderRows(1);
                    PdfPCell[] cells = tbl2.getRow(0).getCells();
                    for (PdfPCell cell : cells) {
                        cell.setBackgroundColor(BaseColor.GRAY);
                    }

                    ArrayList<String> lclcompany_name = new ArrayList<>(emp_history_company);
                    ArrayList<String> lcltime_period = new ArrayList<>(emp_history_time);
                    ArrayList<String> lclrole_in_company = new ArrayList<>(emp_history_role);

                    for (int i = 0; i < lclcompany_name.size(); i++) {
                        tbl2.addCell(lclcompany_name.get(i));
                        tbl2.addCell(lcltime_period.get(i));
                        tbl2.addCell(lclrole_in_company.get(i));
                    }
                    document.add(tbl2);
                    document.add(Chunk.NEWLINE);

                    /////////////////////////////////

                    document.add(new Paragraph("Skills"));

                    List list = new List(List.UNORDERED);
                    list.setAutoindent(false);
                    list.setSymbolIndent(30);

                    ArrayList<String> lclskills = new ArrayList<>(skills_list);

                    for (int i = 0; i < lclskills.size();i++){
                        list.add(new ListItem(lclskills.get(i)));
                    }

                    document.add(list);
                    document.add(Chunk.NEWLINE);

                    //////////////////////////////////////////

                    document.add(new Paragraph("hobbies"));

                    List list2 = new List(List.UNORDERED);
                    list.setAutoindent(false);
                    list.setSymbolIndent(30);

                    ArrayList<String> lclhobbies = new ArrayList<>(hobbies_list);

                    for (int i = 0; i < lclhobbies.size();i++){
                        list2.add(new ListItem(lclhobbies.get(i)));
                    }

                    document.add(list2);
                    document.add(Chunk.NEWLINE);

                    /////////////////////////////////////////////

                    document.add(new Paragraph("Languages"));

                    List list3 = new List(List.UNORDERED);
                    list.setAutoindent(false);
                    list.setSymbolIndent(30);

                    ArrayList<String> lcllanguages = new ArrayList<>(lang_list);

                    for (int i = 0; i < lcllanguages.size();i++){
                        list3.add(new ListItem(lcllanguages.get(i)));
                    }
                    document.add(list3);

                    document.close();


                    MDToast.makeText(getApplicationContext(),"FILE Saved in:- "+savepdfto,MDToast.LENGTH_LONG,MDToast.TYPE_ERROR).show();
                    tvpath.setText("FILE is Saved in:- "+savepdfto);

                } catch (DocumentException e) {
                    e.printStackTrace();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


        DatabaseReference personaldb = FirebaseDatabase.getInstance().getReference("personal_details");
        personaldb.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                name=dataSnapshot.child("name").getValue(String.class);
                phono=dataSnapshot.child("phoneno").getValue(String.class);
                email=dataSnapshot.child("email").getValue(String.class);
                address=dataSnapshot.child("address").getValue(String.class);
                personaldesc=dataSnapshot.child("description").getValue(String.class);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        DatabaseReference education_ref = FirebaseDatabase.getInstance().getReference("education_details");
        education_ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                grade10scored=dataSnapshot.child("scored10").getValue(String.class);
                grade12scored=dataSnapshot.child("scored12").getValue(String.class);
                grade10total=dataSnapshot.child("total10").getValue(String.class);
                grade12total=dataSnapshot.child("total12").getValue(String.class);
                gradscored=dataSnapshot.child("scoredgrad").getValue(String.class);
                gradtotal=dataSnapshot.child("totalgrad").getValue(String.class);
                postgradscored=dataSnapshot.child("scoredpost").getValue(String.class);
                postgradtotal=dataSnapshot.child("totalpost").getValue(String.class);
                percent10=dataSnapshot.child("percent10").getValue(String.class);
                percent12=dataSnapshot.child("percent12").getValue(String.class);
                percentgrad=dataSnapshot.child("percentgrad").getValue(String.class);
                percentpost=dataSnapshot.child("percentpost").getValue(String.class);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        DatabaseReference emphistory_ref = FirebaseDatabase.getInstance().getReference("employment_history");
        emphistory_ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot ds:dataSnapshot.getChildren()){

                    emp_history_company.add(ds.child("company_name").getValue(String.class));
                    emp_history_time.add(ds.child("time_period").getValue(String.class));
                    emp_history_role.add(ds.child("role_in_company").getValue(String.class));

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        DatabaseReference skill_ref = FirebaseDatabase.getInstance().getReference("capability").child("skills");
        skill_ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds:dataSnapshot.getChildren()){

                    skills_list.add(ds.child("skill").getValue(String.class));

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        DatabaseReference hobby_ref = FirebaseDatabase.getInstance().getReference("capability").child("hobbies");
        hobby_ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds:dataSnapshot.getChildren()){

                    hobbies_list.add(ds.child("hobby").getValue(String.class));

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        DatabaseReference language_ref = FirebaseDatabase.getInstance().getReference("capability").child("languages");
        language_ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot ds:dataSnapshot.getChildren()){

                    lang_list.add(ds.child("language").getValue(String.class));

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
}
