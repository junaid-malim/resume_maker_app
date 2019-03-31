package com.collegeutilapp.junaid.resume_maker;

import android.content.Context;
import android.os.Environment;
import android.widget.Toast;

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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

class Genrate_pdf_mtds {

    Genrate_pdf_mtds(Context context) {

        try {

            Date date = new Date();
            DateFormat dateFormat = new SimpleDateFormat("yyyymmddhhmms");

            Document document = new Document();
            //PdfWriter pdfw = PdfWriter.getInstance(document, new FileOutputStream("PDF" + dateFormat.format(date)));
            String saveencryptedto= Environment.getExternalStorageDirectory()+ File.separator+"Encryptedfiles"+File.separator;
            PdfWriter.getInstance(document,new FileOutputStream(saveencryptedto+"pdf" + dateFormat.format(date)+".pdf"));

            document.open();
            Retrive_data_from_fbase fbasedata = new Retrive_data_from_fbase();

            document.add(new Paragraph("name:- "+fbasedata.getName()));
            document.add(new Paragraph("address:- " + fbasedata.getAddress()));
            document.add(new Paragraph("email:- " + fbasedata.getEmail()));
            document.add(new Paragraph("phone:- " + fbasedata.getPhono()));
            document.add(Chunk.NEWLINE);

            PdfPTable table = new PdfPTable(new float[]{1f, 4f});
            table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell("personal description");
            table.addCell(fbasedata.getPersonaldesc());
            table.setHeaderRows(1);
            document.add(table);
            document.add(Chunk.NEWLINE);
            document.add(new Paragraph("Education Details"));
            PdfPTable tbl1 = new PdfPTable(new float[]{1f, 4f});
            tbl1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            tbl1.addCell("10th standard");
            tbl1.addCell("SCORED: " + fbasedata.getGrade10scored() + " out of " + fbasedata.getGrade10total() + " " + fbasedata.getPercent10());
            tbl1.addCell("12th standard");
            tbl1.addCell("SCORED: " + fbasedata.getGrade12scored() + " out of " + fbasedata.getGrade12total() + " " + fbasedata.getPercent12());
            tbl1.addCell("graduation");
            tbl1.addCell("SCORED: " + fbasedata.getGradscored() + " out of " + fbasedata.getGradtotal() + " " + fbasedata.getPercentgrad());
            tbl1.addCell("post graduation");
            tbl1.addCell("SCORED: " + fbasedata.getPostgradscored() + " out of " + fbasedata.getPostgradtotal() + " " + fbasedata.getPercentpost());
            document.add(tbl1);
            document.newPage();
            document.add(new Paragraph("Employement History"));
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

            ArrayList<String> lclcompany_name = new ArrayList<>(fbasedata.getEmp_history_company());
            ArrayList<String> lcltime_period = new ArrayList<>(fbasedata.getEmp_history_time());
            ArrayList<String> lclrole_in_company = new ArrayList<>(fbasedata.getEmp_history_role());

            for (int i = 0; i < lclcompany_name.size(); i++) {
                tbl2.addCell(lclcompany_name.get(i));
                tbl2.addCell(lcltime_period.get(i));
                tbl2.addCell(lclrole_in_company.get(i));
            }
            document.add(tbl2);
            document.add(Chunk.NEWLINE);
            document.add(new Paragraph("Skills"));

            List list = new List(List.UNORDERED);
            list.setAutoindent(false);
            list.setSymbolIndent(30);

            ArrayList<String> lclskills = new ArrayList<>(fbasedata.getSkills_list());

            for (int i = 0; i < lclskills.size();i++){
                list.add(new ListItem(lclskills.get(i)));
            }

            document.add(list);
            document.add(Chunk.NEWLINE);
            document.add(new Paragraph("hobbies"));

            List list2 = new List(List.UNORDERED);
            list.setAutoindent(false);
            list.setSymbolIndent(30);

            ArrayList<String> lclhobbies = new ArrayList<>(fbasedata.getHobbies_list());

            for (int i = 0; i < lclhobbies.size();i++){
                list2.add(new ListItem(lclhobbies.get(i)));
            }

            document.add(list2);
            document.add(Chunk.NEWLINE);
            document.add(new Paragraph("Languages"));

            List list3 = new List(List.UNORDERED);
            list.setAutoindent(false);
            list.setSymbolIndent(30);

            ArrayList<String> lcllanguages = new ArrayList<>(fbasedata.getLang_list());

            for (int i = 0; i < lcllanguages.size();i++){
                list3.add(new ListItem(lcllanguages.get(i)));
            }
            document.add(list3);
            document.add(Chunk.NEWLINE);

            document.close();


            Toast.makeText(context,"FILE Saved",Toast.LENGTH_LONG).show();

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

}
