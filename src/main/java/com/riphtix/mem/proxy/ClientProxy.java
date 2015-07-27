package com.riphtix.mem.proxy;

import com.riphtix.mem.init.MoreBlocks;
import com.riphtix.mem.init.MoreItems;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerRenders(){
		MoreBlocks.registerRenders();
		MoreItems.registerRenders();
	}

}
