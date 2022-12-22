package mk.finki.ukim.epharmacy.model.factory;

import mk.finki.ukim.epharmacy.model.enumerations.ORDER_STATUS;

public class OrderStatusFactory {

    public static ORDER_STATUS getOrderStatusFromString(String status)
    {
        if(status.equalsIgnoreCase("CREATED"))
            return ORDER_STATUS.CREATED;
        else if (status.equalsIgnoreCase("CANCELLED"))
            return ORDER_STATUS.CANCELLED;
        else
            return ORDER_STATUS.FINISHED;
    }
}
