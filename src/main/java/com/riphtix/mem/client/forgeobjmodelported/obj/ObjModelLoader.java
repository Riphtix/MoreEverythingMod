package com.riphtix.mem.client.forgeobjmodelported.obj;

import com.riphtix.mem.client.forgeobjmodelported.IModelCustom;
import com.riphtix.mem.client.forgeobjmodelported.IModelCustomLoader;
import com.riphtix.mem.client.forgeobjmodelported.ModelFormatException;
import net.minecraft.util.ResourceLocation;

public class ObjModelLoader implements IModelCustomLoader
{

  @Override
  public String getType()
  {
    return "OBJ model";
  }

  private static final String[] types = { "obj" };
  @Override
  public String[] getSuffixes()
  {
    return types;
  }

  @Override
  public IModelCustom loadInstance(ResourceLocation resource) throws ModelFormatException
  {
    return new WavefrontObject(resource);
  }
}