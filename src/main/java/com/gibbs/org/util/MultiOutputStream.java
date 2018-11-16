package com.gibbs.org.util;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Redirect <code>System.out</code> to File and to console
 * 
 * @author Lodewijk Pool
 * @see <a href=
 *      "https://www.codeproject.com/Tips/315892/A-quick-and-easy-way-to-direct-Java-System-out-to">System.out
 *      to File and to Console.</a>
 *
 */
public class MultiOutputStream extends OutputStream {
	OutputStream[] outputStreams;

	public MultiOutputStream(OutputStream... outputStreams) {
		this.outputStreams = outputStreams;
	}

	@Override
	public void write(int b) throws IOException {
		for (OutputStream out : outputStreams)
			out.write(b);
	}

	@Override
	public void write(byte[] b) throws IOException {
		for (OutputStream out : outputStreams)
			out.write(b);
	}

	@Override
	public void write(byte[] b, int off, int len) throws IOException {
		for (OutputStream out : outputStreams)
			out.write(b, off, len);
	}

	@Override
	public void flush() throws IOException {
		for (OutputStream out : outputStreams)
			out.flush();
	}

	@Override
	public void close() throws IOException {
		for (OutputStream out : outputStreams)
			out.close();
	}

}
