/**
 * generated by Xtext 2.10.0
 */
package org.rslingo.rsl;

import org.rslingo.rsl.RslStandaloneSetupGenerated;

/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
@SuppressWarnings("all")
public class RslStandaloneSetup extends RslStandaloneSetupGenerated {
  public static void doSetup() {
    RslStandaloneSetup _rslStandaloneSetup = new RslStandaloneSetup();
    _rslStandaloneSetup.createInjectorAndDoEMFRegistration();
  }
}
