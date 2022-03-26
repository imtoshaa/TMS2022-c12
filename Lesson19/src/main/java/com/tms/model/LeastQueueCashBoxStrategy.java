package com.tms.model;

import com.tms.model.CashBox;
import com.tms.model.ChooseCashBoxStrategy;

public class LeastQueueCashBoxStrategy implements ChooseCashBoxStrategy {

    @Override
    public CashBox chooseCashBox(String customerName, CashBox[] cashBoxes) {
        System.out.println(customerName + " picking CashBox by comparing queues size");
        int min = Integer.MAX_VALUE;
        CashBox minBox = null;
        for (CashBox box : cashBoxes) {
            if (box.getQueueSize() < min) {
                min = box.getQueueSize();
                minBox = box;
            }
        }
        return minBox;
    }
}
