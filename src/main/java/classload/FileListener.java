package classload;

import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;

import java.io.File;

public class FileListener  extends FileAlterationListenerAdaptor{

    @Override
    public void onFileChange(File file) {
        if (file.getName().indexOf(".class")!= -1){

            try {
                MyClassLoad myClassLoader = new MyClassLoad(MyApplication.rootPath,MyApplication.rootPath+"/com");
                MyApplication.start0(myClassLoader);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }


    }
}
