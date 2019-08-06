package com.example.spotserve.web_server;

import android.content.Context;
import android.util.Log;
import android.webkit.MimeTypeMap;
import fi.iki.elonen.NanoHTTPD;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

public class WebServer extends NanoHTTPD {

  public WebServer(int port) {
    super(port);
  }

  @Override
  public Response serve(IHTTPSession session) {
    String msg = "<html><body><h1>Hello server</h1>\n";
    Map<String, String> parms = session.getParms();
    if (parms.get("username") == null) {
      msg +=
          "<form action='?' method='get'>\n  <p>Your name: <input type='text' name='username'></p>\n"
              + "</form>\n";
    } else {
      msg += "<p>Hello, " + parms.get("username") + "!</p>";
    }
    return newFixedLengthResponse(msg + "</body></html>\n");
  }
}
