package modal.systemData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import modal.beans.Home;

/**
 *
 * @author isuru Priyamantha
 */
public class HomeInfo {

    public HomeInfo() throws IOException {
        File file = new File(System.getProperty("user.dir")+"\\homeinfo.ser");
        file.createNewFile();
    }
    
    public Home getHome() throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream inputStream = new FileInputStream("homeinfo.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        Home home = (Home) objectInputStream.readObject();
        objectInputStream.close();
        return home;
    }

    public void setHome(Home home) throws FileNotFoundException, IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("homeinfo.ser"));
        objectOutputStream.writeObject(home);
        objectOutputStream.close();
    }

}
