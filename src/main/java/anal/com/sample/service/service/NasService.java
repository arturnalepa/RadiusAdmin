package anal.com.sample.service.service;

import anal.com.sample.model.Nas;
import anal.com.sample.repository.broker.INasBroker;
import anal.com.sample.repository.service.INasService;
import anal.com.sample.service.broker.NasBroker;

import java.util.List;

public class NasService implements INasService {
    private INasBroker broker;

    public NasService() {
        broker = new NasBroker();
    }

    @Override
    public void saveOrUpdate(Nas nas) {
        broker.saveOrUpdate(nas);
    }

    @Override
    public List<Nas>  getAllNas() {
         return broker.getAllNas();
    }

    @Override
       public Nas getNasByNasname(String nasName) {return  broker.getNasByNasname(nasName);
    }

}
