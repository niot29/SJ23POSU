package BusinessObject;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Vd implements PropertyChangeListener {


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("Info to VD: " + evt.getPropertyName() + ": " + evt.getNewValue());
    }
}
