package anal.com.sample.repository.service;

import anal.com.sample.model.Nas;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface INasService {
    void saveOrUpdate(Nas nas);

    List<Nas> getAllNas();

    Nas getNasByNasname(String nasName);


}
