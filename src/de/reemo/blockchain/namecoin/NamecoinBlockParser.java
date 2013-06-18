package de.reemo.blockchain.namecoin;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.codec.binary.Hex;

import de.reemo.blockchain.Block;
import de.reemo.blockchain.BlockInputStreamReader;
import de.reemo.blockchain.BlockParser;

public class NamecoinBlockParser extends BlockParser {


	@Override
	public Block parseBlock(byte[] blockByteArray) throws IOException {
		BlockInputStreamReader reader = new BlockInputStreamReader(new ByteArrayInputStream(blockByteArray));
		NamecoinBlock block = new NamecoinBlock();
		block.hash = getHeaderHash(blockByteArray, 0, 80);
		try {
			block.parse(reader, false);
		} catch(Exception e) {
			e.printStackTrace();
		}
//		if(block.timestamp.getTime() == 1318070401000L) {
//			System.out.println(block.txs[1].txOut[0].script[0]);
//			System.out.println(reader.toStringWithBreaks(blockByteArray));
//		}
		return block;
	}

}
