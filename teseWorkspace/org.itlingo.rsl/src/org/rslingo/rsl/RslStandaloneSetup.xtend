/*
 * generated by Xtext 2.10.0
 */
package org.rslingo.rsl


/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
class RslStandaloneSetup extends RslStandaloneSetupGenerated {

	def static void doSetup() {
		new RslStandaloneSetup().createInjectorAndDoEMFRegistration()
	}
}