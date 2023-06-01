package com.undabits.persistence.adapters_factory;

import com.undabits.persistence.ConfigFileDb;
import com.undabits.persistence.adapters.IAdapter;

public  abstract class AdapterFactory  {

    public IAdapter getAdapter(ConfigFileDb file) {
        return this.createAdapter(file);
    }

    protected abstract IAdapter createAdapter(ConfigFileDb file);

}
