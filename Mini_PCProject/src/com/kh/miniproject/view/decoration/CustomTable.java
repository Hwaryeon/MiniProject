package com.kh.miniproject.view.decoration;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CustomTable extends JTable
{
   @Override
   public boolean isCellEditable(int row, int column)
   {
      return false;
   }
   
   public CustomTable()
   {
      super();
   }
   
   public CustomTable(String[][] rowCount, String[] columnCount)
   {
      super(rowCount, columnCount);
   }
   
}