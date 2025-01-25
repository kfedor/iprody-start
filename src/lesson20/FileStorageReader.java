package lesson20;

import lesson20.interfaces.ObjectStorageReader;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * The class is associated with File Storage. The File Storage Reader class is aimed at working with files.
 */
public class FileStorageReader implements ObjectStorageReader {

    private final FileStorage<Path> fileStorage;

    /**
     * Constructs File store reader.
     * @param fileStorage on which file store reader is based.
     */
    public FileStorageReader(FileStorage<Path> fileStorage) {
        this.fileStorage = fileStorage;
    }

    @Override
    public byte[] read(String nameSpace, String name) {
        try {
            return Files.readAllBytes(fileStorage.get(nameSpace, name));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<byte[]> read(String nameSpace, String name, int chunkSize) {
        List<byte[]> chunks = new ArrayList<>();
        try
                (
                        RandomAccessFile file = new RandomAccessFile(fileStorage.get(nameSpace, name).toFile(), "rw");
                        FileChannel fileChannel = file.getChannel()
                ) {
            ByteBuffer byteBuffer = ByteBuffer.allocate(chunkSize);

            while (fileChannel.read(byteBuffer) != -1) {
                byteBuffer.flip();

                byte[] bytes = new byte[byteBuffer.remaining()];
                byteBuffer.get(bytes);
                chunks.add(bytes);
                byteBuffer.clear();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return chunks;
    }
}
