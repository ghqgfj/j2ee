package tags;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class HelloTagAttribute extends SimpleTagSupport{
    private String message;
    public void setMsg(String msg){
        this.message=msg;
    }
    StringWriter sw=new StringWriter();
    public void doTag() throws JspException, IOException{
        if(message!=null){
            JspWriter out=getJspContext().getOut();
            out.println(message);
        }else{
            getJspBody().invoke(sw);
            getJspContext().getOut().println(sw.toString());
        }
    }
}
