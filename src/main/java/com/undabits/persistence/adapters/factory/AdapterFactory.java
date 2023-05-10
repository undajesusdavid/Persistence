package com.undabits.persistence.adapters.factory;

import com.undabits.persistence.ConfigFileDb;
import com.undabits.persistence.adapters.IPersistenceAdapter;

public  abstract class AdapterFactory  {

    public IPersistenceAdapter getAdapter(ConfigFileDb file) {
        return this.createAdapter(file);
    }

    protected abstract IPersistenceAdapter createAdapter(ConfigFileDb file);

}
