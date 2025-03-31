package service;

import dao.ReaderDao;
import dto.ReaderDto;
import entity.Reader;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

@WebService(name = "ReaderWebService")
public class ReaderWebService {

    private final ReaderDao readerDao = ReaderDao.getInstance();

    @WebMethod(operationName = "saveReader")
    public Reader saveReader(
            @WebParam(name = "name") String name,
            @WebParam(name = "email") String email,
            @WebParam(name = "phone") String phone) {
        return readerDao.save(new ReaderDto(name, email, phone));
    }
}
