package sample.reader;

import framework.DataReader;
import sample.util.Converter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gun on 2015-12-08.
 */
public class FileDataReader<T> implements DataReader<T> {

    private BufferedReader bufferedReader;
    private Converter converter;
    private String currentLine;
    private List<String> list;
    private int index=0;


    public FileDataReader(String fileName) throws IOException{
        converter = new Converter();
        bufferedReader = new BufferedReader(new FileReader(fileName));
        list = new ArrayList<String>();
        while ((currentLine = bufferedReader.readLine()) != null){
            list.add(currentLine);
        }

        bufferedReader.close();
    }


    public T readData(){
        String string=list.get(index);
        index++;
        return  converter.convertToT(string);
    }

}
