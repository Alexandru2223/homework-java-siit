package tema11.ATM;

import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.nio.charset.StandardCharsets.UTF_8;


public class BankAccountRepository {
    public static List<User> bankAccounts = new ArrayList<>();
   public static Path bankAccountDB = Paths.get("files", "bank_account.csv");

    public BankAccountRepository() throws IOException {
       bankAccounts = Files.lines(bankAccountDB)
                            .skip(1)
                            .filter(StringUtils::isNotBlank)
                            .map(BankAccountRepository::mapLineToBankAccount)
                            .collect(Collectors.toList());
    }

    public static User mapLineToBankAccount(@NotNull String line) {
        String[] fields = line.split(",");
        return User.builder()
                   .name(fields[0])
                          .card(new Card(new BankAccount(fields[1], new BigDecimal(fields[2])),fields[3],fields[4], Integer.parseInt(fields[5])))
                          .build();
    }
    public static void rewriteBankAccountsDB(Path fileDB, List<User> bankAccounts) throws IOException {


        String newFileName = fileDB.toString().substring(0, fileDB.toString().length() - 4) + ".csv";

        BufferedWriter writer = Files.newBufferedWriter(Paths.get(newFileName), UTF_8, StandardOpenOption.CREATE);
        writeHearer(writer);
        bankAccounts.forEach(bankAccount -> writeBankAccountEntry(writer, bankAccount));
        writer.flush();
    }

    private static void writeHearer(BufferedWriter writer) {
        try {
            writer.write("ownerName,IBAN,balance,number,expDate,pin");
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Exception while writing header ");
        }
    }

    private static void writeBankAccountEntry(BufferedWriter writer, User user) {
        try {
            writer.write( user.getName()+ "," + user.getCard().bankAccount.getIban() + "," + user.getCard().bankAccount.getBalance() +"," +
                    user.getCard().getCardNumber() + "," + user.getCard().getExpDate() + "," + user.getCard().getPin());
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Exception while writing bankAccount: " + user);
        }
    }

}
