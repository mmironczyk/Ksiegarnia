package com.ksiegarnia;

public class AdminPanel {
    private static boolean ordersPanel;
    private static boolean reservationPanel;

    public static boolean isOrdersPanel() {
        return ordersPanel;
    }

    public static void setOrdersPanel(boolean ordersPanel) {
        AdminPanel.ordersPanel = ordersPanel;
    }

    public boolean isReservationPanel() {
        return reservationPanel;
    }

    public void setReservationPanel(boolean reservationPanel) {
        AdminPanel.reservationPanel = reservationPanel;
    }
}
