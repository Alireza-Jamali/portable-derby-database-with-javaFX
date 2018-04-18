package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class DatabaseService {

    private String url = "jdbc:derby:JobHours;create=true;user=sa;password=123456";
    private String user = "sa";
    private String password = "123456";
    private Connection cn;
    private Statement st;
    public long ezaf;
    public long kasri;
    public long effEzaf;
    public String ezafT;
    public String kasriT;
    public String effEzafT;

    private SimpleDateFormat format = new SimpleDateFormat("HH:mm");

    public void reset() {

        try {
            st.executeUpdate("UPDATE SA.TB_HOURS SET ENTRY = '09:00:00', EXIT = '17:00:00', COFFEESHOP = 0, LEAVE = '0-0'");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void connect() {

        try {

            cn = DriverManager.getConnection(url);
            System.out.println("Connected!");

            if (!cn.getMetaData().getTables(null, "SA", "TB_HOURS", null).next()) {
                System.out.println("Table doesn't exist, Creating Table...");
                cn.setAutoCommit(false); 
                cn.prepareStatement("CREATE TABLE SA.TB_HOURS\n"
                        + "    (DATE VARCHAR(3),\n"
                        + "    ENTRY TIME,\n"
                        + "    EXIT TIME,\n"
                        + "    COFFEESHOP INT,\n"
                        + "    LEAVE VARCHAR(12))").executeUpdate();
                
                cn.prepareStatement("INSERT INTO SA.TB_HOURS (DATE, ENTRY, EXIT, COFFEESHOP, LEAVE) \n"
                        + "	VALUES ('21', '09:00:00', '17:00:00', 0, '0-0')").executeUpdate();
                cn.prepareStatement("INSERT INTO SA.TB_HOURS (DATE, ENTRY, EXIT, COFFEESHOP, LEAVE) \n"
                        + "	VALUES ('22', '09:00:00', '17:00:00', 0, '0-0')").executeUpdate();
                cn.prepareStatement("INSERT INTO SA.TB_HOURS (DATE, ENTRY, EXIT, COFFEESHOP, LEAVE) \n"
                        + "	VALUES ('23', '09:00:00', '17:00:00', 0, '0-0')").executeUpdate();
                cn.prepareStatement("INSERT INTO SA.TB_HOURS (DATE, ENTRY, EXIT, COFFEESHOP, LEAVE) \n"
                        + "	VALUES ('24', '09:00:00', '17:00:00', 0, '0-0')").executeUpdate();
                cn.prepareStatement("INSERT INTO SA.TB_HOURS (DATE, ENTRY, EXIT, COFFEESHOP, LEAVE) \n"
                        + "	VALUES ('25', '09:00:00', '17:00:00', 0, '0-0')").executeUpdate();
                cn.prepareStatement("INSERT INTO SA.TB_HOURS (DATE, ENTRY, EXIT, COFFEESHOP, LEAVE) \n"
                        + "	VALUES ('26', '09:00:00', '17:00:00', 0, '0-0')").executeUpdate();
                cn.prepareStatement("INSERT INTO SA.TB_HOURS (DATE, ENTRY, EXIT, COFFEESHOP, LEAVE) \n"
                        + "	VALUES ('27', '09:00:00', '17:00:00', 0, '0-0')").executeUpdate();
                cn.prepareStatement("INSERT INTO SA.TB_HOURS (DATE, ENTRY, EXIT, COFFEESHOP, LEAVE) \n"
                        + "	VALUES ('28', '09:00:00', '17:00:00', 0, '0-0')").executeUpdate();
                cn.prepareStatement("INSERT INTO SA.TB_HOURS (DATE, ENTRY, EXIT, COFFEESHOP, LEAVE) \n"
                        + "	VALUES ('29', '09:00:00', '17:00:00', 0, '0-0')").executeUpdate();
                cn.prepareStatement("INSERT INTO SA.TB_HOURS (DATE, ENTRY, EXIT, COFFEESHOP, LEAVE) \n"
                        + "	VALUES ('30', '09:00:00', '17:00:00', 0, '0-0')").executeUpdate();
                cn.prepareStatement("INSERT INTO SA.TB_HOURS (DATE, ENTRY, EXIT, COFFEESHOP, LEAVE) \n"
                        + "	VALUES ('31', '09:00:00', '17:00:00', 0, '0-0')").executeUpdate();
                cn.prepareStatement("INSERT INTO SA.TB_HOURS (DATE, ENTRY, EXIT, COFFEESHOP, LEAVE) \n"
                        + "	VALUES ('01', '09:00:00', '17:00:00', 0, '0-0')").executeUpdate();
                cn.prepareStatement("INSERT INTO SA.TB_HOURS (DATE, ENTRY, EXIT, COFFEESHOP, LEAVE) \n"
                        + "	VALUES ('02', '09:00:00', '17:00:00', 0, '0-0')").executeUpdate();
                cn.prepareStatement("INSERT INTO SA.TB_HOURS (DATE, ENTRY, EXIT, COFFEESHOP, LEAVE) \n"
                        + "	VALUES ('03', '09:00:00', '17:00:00', 0, '0-0')").executeUpdate();
                cn.prepareStatement("INSERT INTO SA.TB_HOURS (DATE, ENTRY, EXIT, COFFEESHOP, LEAVE) \n"
                        + "	VALUES ('04', '09:00:00', '17:00:00', 0, '0-0')").executeUpdate();
                cn.prepareStatement("INSERT INTO SA.TB_HOURS (DATE, ENTRY, EXIT, COFFEESHOP, LEAVE) \n"
                        + "	VALUES ('05', '09:00:00', '17:00:00', 0, '0-0')").executeUpdate();
                cn.prepareStatement("INSERT INTO SA.TB_HOURS (DATE, ENTRY, EXIT, COFFEESHOP, LEAVE) \n"
                        + "	VALUES ('06', '09:00:00', '17:00:00', 0, '0-0')").executeUpdate();
                cn.prepareStatement("INSERT INTO SA.TB_HOURS (DATE, ENTRY, EXIT, COFFEESHOP, LEAVE) \n"
                        + "	VALUES ('07', '09:00:00', '17:00:00', 0, '0-0')").executeUpdate();
                cn.prepareStatement("INSERT INTO SA.TB_HOURS (DATE, ENTRY, EXIT, COFFEESHOP, LEAVE) \n"
                        + "	VALUES ('08', '09:00:00', '17:00:00', 0, '0-0')").executeUpdate();
                cn.prepareStatement("INSERT INTO SA.TB_HOURS (DATE, ENTRY, EXIT, COFFEESHOP, LEAVE) \n"
                        + "	VALUES ('09', '09:00:00', '17:00:00', 0, '0-0')").executeUpdate();
                cn.prepareStatement("INSERT INTO SA.TB_HOURS (DATE, ENTRY, EXIT, COFFEESHOP, LEAVE) \n"
                        + "	VALUES ('10', '09:00:00', '17:00:00', 0, '0-0')").executeUpdate();
                cn.prepareStatement("INSERT INTO SA.TB_HOURS (DATE, ENTRY, EXIT, COFFEESHOP, LEAVE) \n"
                        + "	VALUES ('11', '09:00:00', '17:00:00', 0, '0-0')").executeUpdate();
                cn.prepareStatement("INSERT INTO SA.TB_HOURS (DATE, ENTRY, EXIT, COFFEESHOP, LEAVE) \n"
                        + "	VALUES ('12', '09:00:00', '17:00:00', 0, '0-0')").executeUpdate();
                cn.prepareStatement("INSERT INTO SA.TB_HOURS (DATE, ENTRY, EXIT, COFFEESHOP, LEAVE) \n"
                        + "	VALUES ('13', '09:00:00', '17:00:00', 0, '0-0')").executeUpdate();
                cn.prepareStatement("INSERT INTO SA.TB_HOURS (DATE, ENTRY, EXIT, COFFEESHOP, LEAVE) \n"
                        + "	VALUES ('14', '09:00:00', '17:00:00', 0, '0-0')").executeUpdate();
                cn.prepareStatement("INSERT INTO SA.TB_HOURS (DATE, ENTRY, EXIT, COFFEESHOP, LEAVE) \n"
                        + "	VALUES ('15', '09:00:00', '17:00:00', 0, '0-0')").executeUpdate();
                cn.prepareStatement("INSERT INTO SA.TB_HOURS (DATE, ENTRY, EXIT, COFFEESHOP, LEAVE) \n"
                        + "	VALUES ('16', '09:00:00', '17:00:00', 0, '0-0')").executeUpdate();
                cn.prepareStatement("INSERT INTO SA.TB_HOURS (DATE, ENTRY, EXIT, COFFEESHOP, LEAVE) \n"
                        + "	VALUES ('17', '09:00:00', '17:00:00', 0, '0-0')").executeUpdate();
                cn.prepareStatement("INSERT INTO SA.TB_HOURS (DATE, ENTRY, EXIT, COFFEESHOP, LEAVE) \n"
                        + "	VALUES ('18', '09:00:00', '17:00:00', 0, '0-0')").executeUpdate();
                cn.prepareStatement("INSERT INTO SA.TB_HOURS (DATE, ENTRY, EXIT, COFFEESHOP, LEAVE) \n"
                        + "	VALUES ('19', '09:00:00', '17:00:00', 0, '0-0')").executeUpdate();
                cn.prepareStatement("INSERT INTO SA.TB_HOURS (DATE, ENTRY, EXIT, COFFEESHOP, LEAVE) \n"
                        + "	VALUES ('20', '09:00:00', '17:00:00', 0, '0-0')").executeUpdate();
                
                cn.commit();
                System.out.println("Table Created.");
                cn.setAutoCommit(true);
            }//table create if

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public DatabaseService() {

        connect();
        try {
            st = cn.createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ResultSet getRows() {

        ResultSet rs = null;
        try {

            rs = st.executeQuery("SELECT * FROM SA.TB_HOURS");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return rs;
    }

    public String getDate(String date) {

        String s = null;
        ResultSet rs = null;
        try {

            rs = st.executeQuery("SELECT DATE FROM SA.TB_HOURS WHERE DATE = " + date);
            s = rs.getString("DATE");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return s;
    }

    public ResultSet getLeave() {

        ResultSet rs = null;
        try {

            rs = st.executeQuery("SELECT LEAVE FROM SA.TB_HOURS");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return rs;
    }

    public ResultSet getCoffee() {

        ResultSet rs = null;
        try {

            rs = st.executeQuery("SELECT COFFEESHOP FROM SA.TB_HOURS");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return rs;
    }

    public void insertDate(String modifiedDate, String date) {

        try {

            String quary = "UPDATE TB_HOURS SET Date = '" + modifiedDate + "' WHERE DATE = '" + date + "'";
            st.executeUpdate(quary);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void insertEntry(String date, String entry) {

        try {

            String quary = "UPDATE TB_HOURS SET ENTRY = '" + entry + "' WHERE DATE = '" + date + "'";

            st.executeUpdate(quary);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void insertExit(String date, String exit) {

        try {

            String quary = "UPDATE TB_HOURS SET EXIT = '" + exit + "' WHERE DATE = '" + date + "'";
            st.executeUpdate(quary);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void insertExitResult(String exitResult) {

        try {

            String quary = "UPDATE TB_HOURS SET RESULTS = '" + exitResult + "' WHERE DATE = 22";

            st.executeUpdate(quary);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void insertLeave(String date, String leave) {

        try {

            String quary = "UPDATE TB_HOURS SET LEAVE = '" + leave + "' WHERE DATE = '" + date + "'";

            st.executeUpdate(quary);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void insertCoffeeShop(String date, int coffeeShop) {

        try {

            String quary = "UPDATE TB_HOURS SET COFFEESHOP = " + coffeeShop + " WHERE DATE = '" + date + "'";

            st.executeUpdate(quary);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateAll(String date, String entry, String exit, String leave, int coffeeShop) {

        try {

            String quary = "UPDATE TB_HOURS SET ENTRY = '" + entry + "', EXIT = '" + exit + "', LEAVE = '" + leave + "', COFFEESHOP = " + coffeeShop + " WHERE DATE = '" + date + "'";

            st.executeUpdate(quary);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public String sumCoffee() {

        int sum = 0;
        try {
            ResultSet rs = getRows();
            while (rs.next()) {
                sum += rs.getInt("COFFEESHOP");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sum == 0 ? "" : String.valueOf(sum);
    }

    public void renderLabels() {

        String entry = "";
        String exit = "";
        try {

            long zero = format.parse("00:00").getTime();
            long nine = format.parse("09:00").getTime();
            long twelve = format.parse("23:59").getTime();
            long five = format.parse("17:00").getTime();
            long one = format.parse("13:00").getTime();

            ResultSet rs = getRows();
            while (rs.next()) {
                if (!rs.getString("DATE").contains("p")) {

                    entry = rs.getTime("ENTRY").toString().substring(0, 5);
                    exit = rs.getTime("EXIT").toString().substring(0, 5);

                    long entryDate = format.parse(entry).getTime();
                    long exitDate = format.parse(exit).getTime();

                    if (entryDate > nine && entryDate <= five) {

                        kasri += (entryDate - nine);
                    }

                    if (entryDate < nine) {

                        ezaf += (nine - entryDate);
                    }

                    if (exitDate < five && exitDate >= nine) {

                        kasri += (five - exitDate);
                    }

                    if (exitDate > five && exitDate <= twelve) {

                        ezaf += (exitDate - five);
                    }

                    if (exitDate >= zero && exitDate < nine) {

                        ezaf += (exitDate - zero) + (25200000);
                    }
                } else {

                    entry = rs.getTime("ENTRY").toString().substring(0, 5);
                    exit = rs.getTime("EXIT").toString().substring(0, 5);

                    long entryDate = format.parse(entry).getTime();
                    long exitDate = format.parse(exit).getTime();

                    if (entryDate > nine && entryDate <= one) {

                        kasri += (entryDate - nine);
                    }

                    if (entryDate < nine) {

                        ezaf += (nine - entryDate);
                    }

                    if (exitDate < one && exitDate >= nine) {

                        kasri += (one - exitDate);
                    }

                    if (exitDate > one && exitDate <= twelve) {

                        ezaf += (exitDate - one);
                    }

                    if (exitDate >= zero && exitDate < nine) {

                        ezaf += (exitDate - zero) + (39600000);
                    }
                }
            }
            effEzaf = ezaf - kasri;

            timeFormatter(ezaf, kasri, effEzaf);
            rs.close();
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
    }

    public void renderLabelsForThursday(String entry, String exit) {

        try {

            long zero = format.parse("00:00").getTime();
            long nine = format.parse("09:00").getTime();
            long twelve = format.parse("23:59").getTime();
            long one = format.parse("13:00").getTime();

            long entryDate = format.parse(entry).getTime();
            long exitDate = format.parse(exit).getTime();

            if (entryDate > nine && entryDate <= one) {

                kasri += (entryDate - nine);
            }

            if (entryDate < nine) {

                ezaf += (nine - entryDate);
            }

            if (exitDate < one && exitDate >= nine) {

                kasri += (one - exitDate);
            }

            if (exitDate > one && exitDate <= twelve) {

                ezaf += (exitDate - one);
            }

            if (exitDate >= zero && exitDate < nine) {

                ezaf += (exitDate - zero) + (39600000);
            }

            effEzaf = ezaf - kasri;

            timeFormatter(ezaf, kasri, effEzaf);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void timeFormatter(long ezaf, long kasri, long effEzaf) {

        String min;
        String sec;

        int ezaff = (int) ezaf / 60000;
        int kasrii = (int) kasri / 60000;
        int effEzaff = (int) effEzaf / 60000;

        min = ezaff != 0 ? String.valueOf(ezaff / 60) : "00";
        sec = ezaff != 0 ? String.valueOf(ezaff % 60) : "00";
        ezafT = (min.length() < 2 ? "0" + min : min) + ":" + (sec.length() < 2 ? "0" + sec : sec);

        min = kasrii != 0 ? String.valueOf(kasrii / 60) : "00";
        sec = kasrii != 0 ? String.valueOf(kasrii % 60) : "00";
        kasriT = (min.length() < 2 ? "0" + min : min) + ":" + (sec.length() < 2 ? "0" + sec : sec);

        min = effEzaff != 0 ? String.valueOf(effEzaff / 60) : "00";
        sec = effEzaff != 0 ? String.valueOf(effEzaff % 60) : "00";
        effEzafT = (min.length() < 2 ? "0" + min : min) + ":" + (sec.length() < 2 ? "0" + sec : sec);
    }

    public String sumLeave() {

        ResultSet rs = getLeave();
        int sum = 0;
        try {

            while (rs.next()) {
                String s = rs.getString("LEAVE");
                String[] ss = s.split("-");
                int result = Math.abs(Integer.parseInt(ss[0]) - Integer.parseInt(ss[1]));

                sum += result;
            }

            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return sum == 0 ? "" : String.valueOf(sum);
    }

}
