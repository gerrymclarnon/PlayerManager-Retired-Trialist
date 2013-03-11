package net.playermanager.security;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.springframework.core.ParameterNameDiscoverer;

public class SimpleParameterNameDiscoverer implements ParameterNameDiscoverer {

	public String[] getParameterNames(Method m) {
		return getParameterNames(m.getParameterTypes().length);
	}

	@SuppressWarnings("rawtypes")
	public String[] getParameterNames(Constructor c) {
		return getParameterNames(c.getParameterTypes().length);
	}

	protected String[] getParameterNames(int length) {
		String[] names = new String[length];

		for (int i = 0; i < length; i++)
			names[i] = "arg" + i;

		return names;
	}
}
