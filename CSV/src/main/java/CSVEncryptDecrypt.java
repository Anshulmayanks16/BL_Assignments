import com.opencsv.CSVWriter;
import com.opencsv.CSVReader;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CSVEncryptDecrypt {
    private static final String ALGORITHM = "AES";
    private static final String SECRET_KEY = "1234567890123456";

    public static void main(String[] args) throws Exception {
        String csvFilePath = "New folder/student.csv";
        String encryptedCsvFilePath = "New folder/encrypted_data.csv";
        String decryptedCsvFilePath = "New folder/decrypted_data.csv";
        encryptCSV(csvFilePath, encryptedCsvFilePath);
        decryptCSV(encryptedCsvFilePath, decryptedCsvFilePath);
    }

    public static void encryptCSV(String inputFile, String outputFile) throws Exception {
        CSVReader reader = new CSVReader(new FileReader(inputFile));
        CSVWriter writer = new CSVWriter(new FileWriter(outputFile));
        String[] header = reader.readNext();
        writer.writeNext(header);
        String[] record;
        while ((record = reader.readNext()) != null) {
            if (record.length > 3) {
                record[3] = encrypt(record[3]);
            }
            writer.writeNext(record);
        }
        reader.close();
        writer.close();
    }

    public static void decryptCSV(String inputFile, String outputFile) throws Exception {
        CSVReader reader = new CSVReader(new FileReader(inputFile));
        CSVWriter writer = new CSVWriter(new FileWriter(outputFile));
        String[] header = reader.readNext();
        writer.writeNext(header);
        String[] record;
        while ((record = reader.readNext()) != null) {
            if (record.length > 3) {
                record[3] = decrypt(record[3]);
            }
            writer.writeNext(record);
        }
        reader.close();
        writer.close();
    }

    public static String encrypt(String data) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes(), ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedData = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedData);
    }

    public static String decrypt(String encryptedData) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes(), ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedData = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
        return new String(decryptedData);
    }
}
