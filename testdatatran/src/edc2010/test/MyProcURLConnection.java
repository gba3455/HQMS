package edc2010.test;

import java.net.URLConnection;
import java.util.Map;

import edc2010.util.net.ProcURLConnection;

public class MyProcURLConnection implements ProcURLConnection {

  public Map resProps = null;
  @Override
  public void procResProps(Map resProps) {
    this.resProps = resProps;
//    System.out.println( resProps.toString());
  }

  @Override
  public void procUrlConn(URLConnection uc) {
    // TODO Auto-generated method stub
    
  }

}
