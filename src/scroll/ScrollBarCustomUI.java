package scroll;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class ScrollBarCustomUI extends BasicScrollBarUI {

    private boolean isMin;
    private boolean isMax;
    
    

    @Override
    public void installUI(JComponent c) {
        super.installUI(c);

        // Postpone adding the adjustment listener until scrollbar is initialized
        SwingUtilities.invokeLater(() -> {
            if (scrollbar != null) {
                scrollbar.addAdjustmentListener(e -> {
                    BoundedRangeModel br = scrollbar.getModel();
                    boolean min = br.getValue() == br.getMinimum();
                    boolean max = br.getValue() + br.getExtent() == br.getMaximum();
                    if (isMin != min || isMax != max) {
                        isMin = min;
                        isMax = max;
                        scrollbar.repaint();
                    }
                });
            }
        });
    }

    @Override
    protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
        g.setColor(new Color(240, 240, 240)); // Lighter background for the track
        g.fillRect(trackBounds.x, trackBounds.y, trackBounds.width, trackBounds.height);
    }

    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Color thumbColor = isDragging ? new Color(130, 130, 130)
                : isThumbRollover() ? new Color(150, 150, 150)
                : new Color(180, 180, 180);

        g2.setColor(thumbColor);

        int arc = 10; // Rounded corners
        g2.fill(new RoundRectangle2D.Double(
                thumbBounds.x + 2,
                thumbBounds.y + 8,
                thumbBounds.width - 4,
                thumbBounds.height - 16,
                arc, arc
        ));
        g2.dispose();
    }

    @Override
    protected JButton createIncreaseButton(int orientation) {
        return new ScrollButton(scrollbar.getOrientation(), true);
    }

    @Override
    protected JButton createDecreaseButton(int orientation) {
        return new ScrollButton(scrollbar.getOrientation(), false);
    }

    private class ScrollButton extends JButton {
        private boolean hovered;
        private boolean pressed;
        private final boolean increase;

        public ScrollButton(int orientation, boolean increase) {
            this.increase = increase;
            setPreferredSize(new Dimension(18, 18));
            setContentAreaFilled(false);
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    hovered = true;
                    repaint();
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    hovered = false;
                    repaint();
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    if (SwingUtilities.isLeftMouseButton(e)) {
                        pressed = true;
                        repaint();
                    }
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    pressed = false;
                    repaint();
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            Color buttonColor = pressed ? new Color(150, 150, 150)
                    : hovered ? new Color(200, 200, 200)
                    : new Color(250, 250, 250);
            g2.setColor(buttonColor);
            g2.fillRect(0, 0, getWidth(), getHeight());

            // Draw the arrow
            int size = Math.min(getWidth(), getHeight()) / 2;
            Polygon arrow = new Polygon();

            if (increase) {
                arrow.addPoint(size / 2, size / 4);
                arrow.addPoint(size + size / 2, size / 4);
                arrow.addPoint(size, size);
            } else {
                arrow.addPoint(size, size / 4);
                arrow.addPoint(size + size / 2, size);
                arrow.addPoint(size / 2, size);
            }

            g2.setColor(pressed ? Color.WHITE : Color.GRAY);
            g2.fillPolygon(arrow);

            g2.dispose();
        }
    }
}
