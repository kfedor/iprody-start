package lesson39.library.util;

import org.hibernate.rest.library.dto.ReaderDto;
import org.hibernate.rest.library.entity.Reader;

public class ReaderMapper {

    private ReaderMapper() {
    }

    public static Reader toEntity(ReaderDto dto) {
        Reader reader = new Reader();
        reader.setName(dto.getName());
        reader.setEmail(dto.getEmail());
        if (dto.getPhone() != null) {
            reader.setPhone(dto.getPhone());
        }
        return reader;
    }

    public static ReaderDto toDto(Reader reader) {
        ReaderDto readerDto = new ReaderDto();
        readerDto.setReaderId(reader.getReaderId());
        readerDto.setName(reader.getName());
        readerDto.setEmail(reader.getEmail());
        if (reader.getPhone() != null) {
            readerDto.setPhone(reader.getPhone());
        }
        return readerDto;
    }
}
