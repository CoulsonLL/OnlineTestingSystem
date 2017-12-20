package util;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class RowCounter implements Serializable
{

    private transient int row = 0;

    public int getRow()
    {
        return ++row;
    }
}