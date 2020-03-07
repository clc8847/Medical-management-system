package clc.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import java.util.regex.Pattern;

import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class PerTable {
	static double a =0;
	static Vector col =new Vector();
	static Vector vl =new Vector();
	static int lie=0;
	static int f=0;
	private static JTableHeader tableH;
	public static void makeJTable(final JTable table) {
 
		 table.addMouseMotionListener(new MouseAdapter(){
				public void mouseMoved(MouseEvent e) {
					int row=table.rowAtPoint(e.getPoint());
					int col=table.columnAtPoint(e.getPoint());
					if(row>-1 && col>-1){
						Object value=table.getValueAt(row, col);
						if(null!=value && !"".equals(value))
							table.setToolTipText(value.toString());//悬浮显示单元格内容
						else
							table.setToolTipText(null);//关闭提示
					}
				}
			});
		// 表格排序jdk1.6新功能
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
		table.setRowSorter(sorter);
	 
		// 设置行高
		table.setRowHeight(21);
		// 设置表格线
		table.setGridColor(SystemColor.controlHighlight);

		// table.getTableHeader().set
		// 表头居中显示
		JTableHeader tbh = table.getTableHeader();
	//	tbh.setBackground(new Color(2,158,233));
		tbh.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		
		table.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		
		DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) tbh.getDefaultRenderer();
		renderer.setHorizontalAlignment(SwingConstants.CENTER);
				
		try 
		{
			DefaultTableCellRenderer tcr = new DefaultTableCellRenderer() 
			{
				private static final long serialVersionUID = 1826425922704465800L;
				public Component getTableCellRendererComponent(JTable table,
						Object value, boolean isSelected, boolean hasFocus,
						int row, int column) 
				{
					// 设置奇偶行颜色
					if (row % 2 == 0) {
						setBackground(Color.white); // 设置奇数行底色
					} else if (row % 2 == 1) {
						setBackground(new Color(237, 237, 237)); // 设置偶数行底色
					}
					// 如果为数值则右对齐
					Pattern p = Pattern.compile("^(-?\\d+)(\\.\\d+)?$");
					String sv = (value != null ? value.toString() : "");
					if (p.matcher(sv).matches()) {
						this.setHorizontalAlignment(SwingConstants.LEFT);
						a=a+Double.parseDouble(String.valueOf(value)); 
						if(column!=0)
						{
							if(!col.contains(column))
							{
								col.add(column);
							}
							
						} 
					}
					else 
					{
						this.setHorizontalAlignment(SwingConstants.LEFT);
					}
					return super.getTableCellRendererComponent(table, value,isSelected, hasFocus, row, column);
				}
			};
			for (int i = 0; i < table.getColumnCount(); i++) 
			{
				TableColumn tc = table.getColumn(table.getColumnName(i));
				tc.setCellRenderer(tcr);
			} 
		} 
		catch (Exception ex) 
		{
			ex.printStackTrace();
		}
		table.updateUI();
		Container c = table.getParent();
		if (c instanceof JViewport) {
			JViewport jp = (JViewport) c;
			jp.setBackground(new Color(255,255,204));
		}
	}
	
	public static int getColCount(JTable table,String colName)
	{
		int col=0;
		for(int i=0;i<table.getColumnCount();i++)
		{
			String name = table.getColumnName(i);
			if(name.equals(colName))
			{
				col=i;
			}
		}
		return col;
	}
	
	public static void removeRows(JTable table)
	{
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		for(int i=table.getRowCount()-1;i>=0;i--)
		{
			model.removeRow(i);
		}
		table.updateUI();
	}
}
