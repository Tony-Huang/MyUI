package com.hdp.smp.front.ui.backing.includes;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import oracle.adf.share.logging.ADFLogger;
import oracle.adf.view.rich.component.rich.RichDocument;
import oracle.adf.view.rich.component.rich.RichForm;
import oracle.adf.view.rich.component.rich.layout.RichPanelSplitter;
import oracle.adf.view.rich.render.RichRenderer;
import oracle.adf.view.rich.util.BuildInfo;

import org.apache.http.NameValuePair;
import org.apache.myfaces.trinidad.context.AccessibilityProfile;
import org.apache.myfaces.trinidad.context.RenderingContext;
import org.apache.myfaces.trinidad.context.RequestContext;
import org.apache.myfaces.trinidad.skin.Skin;

public class AboutPopup {
   
    //==================================================================================
    //borrowed from adffaces demo
    //==================================================================================
    public List<NameValuePair> getVersionInformation()
    {
      List<NameValuePair> info = new ArrayList<NameValuePair>();

      RenderingContext rc = RenderingContext.getCurrentInstance();
      if (rc != null)
      {
        // Gather accessibility information (dynamic within a session):
        AccessibilityProfile accProfile = rc.getAccessibilityProfile();
       
        // Gather skin information (dynamic within a session):
        RequestContext requestContext = RequestContext.getCurrentInstance();
        Skin skin = rc.getSkin();
        String skinId = skin.getId();
        if (skinId != null)
        {
          String skinFamily = requestContext.getSkinFamily();
          if (skinFamily != null)
          {
            info.add(new NameValuePair("Skin", skinId + " (" + skinFamily + ")"));
          }
          else
          {
            info.add(new NameValuePair("Skin", skinId));
          }
        }

        // Gather user agent information
        info.add(new NameValuePair("User Agent", rc.getAgent().toString()));

        //Adding an empty pair before the Version Info to allow nicer spacing
        info.add(new NameValuePair("", ""));
        
       
        NameValuePair versionInfoPair = new NameValuePair("Version Information","1.0"); //Version Info
        info.add(versionInfoPair);
      }

      return info;
    }


    public static class NameValuePair implements Serializable
    {
      NameValuePair(String name, String value)
      {
        _name = name;
        _value = value;
      }

      public String getName()
      {
        return _name;
      }

      public String getValue()
      {
        return _value;
      }

      private String _name;
      private String _value;

      private static final long serialVersionUID = 1L;
    }


 

    private static final long serialVersionUID = 1L;
    
    
}
