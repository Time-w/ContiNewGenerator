package top.continew.ui;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * @author lww
 * @date 2025-04-25 19:21
 */
public class MyCellRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus,
            int row, int column) {
        // 调用父类方法设置默认样式
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // 设置隔行变色
        if (!isSelected) {
            // 如果单元格未被选中
            if (row % 2 == 0) {
                // 偶数行的背景色
                setBackground(new Color(179, 238, 203));
            } else {
                // 奇数行的背景色
                setBackground(new Color(207, 232, 239));
            }
        }
        // 设置 Tooltip：当内容被截断时显示完整内容
        String text = value == null ? "" : value.toString();
        setText(text);
        setToolTipText(isTextTruncated(table, column, text) ? text : null);

        return this;
    }

    private boolean isTextTruncated(JTable table, int column, String text) {
        if (text == null || table == null) {
            return false;
        }

        // 获取列宽和字体宽度
        int columnWidth = table.getColumnModel().getColumn(column).getWidth();
        int textWidth = getFontMetrics(getFont()).stringWidth(text);

        return textWidth > columnWidth;
    }

}
