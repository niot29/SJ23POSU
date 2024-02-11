package BusinessObject;

import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;


public class OrderHandler {
    private String orderStatus;
    private String orderProcess;

    private PropertyChangeSupport propertyChangeSupport;

    public OrderHandler() {
        this.propertyChangeSupport = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener){
        this.propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        String oldOrderStatus = this.orderStatus;
        this.orderStatus = orderStatus;
        this.propertyChangeSupport.firePropertyChange("Order Status change",oldOrderStatus,this.orderStatus);
    }

    public String getOrderProcess() {
        return orderProcess;
    }

    public void setOrderProcess(String orderProcess) {
        String OldOrderProcess = this.orderProcess;
        this.orderProcess = orderProcess;
        this.propertyChangeSupport.firePropertyChange("Order Process change",OldOrderProcess,this.orderProcess);
    }
}
