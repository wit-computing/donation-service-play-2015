package utils;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

import models.User;

class JsonFilter implements ExclusionStrategy
{
  public boolean shouldSkipClass(Class<?> arg0)
  {
    return false;
  }

  public boolean shouldSkipField(FieldAttributes f)
  {
    return (f.getDeclaringClass() == User.class && f.getName().equals("donations"));
  }
}