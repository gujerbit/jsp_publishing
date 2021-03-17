package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public interface Controller {
	public void execute(ServletRequest req, ServletResponse res) throws ServletException, IOException;
}
