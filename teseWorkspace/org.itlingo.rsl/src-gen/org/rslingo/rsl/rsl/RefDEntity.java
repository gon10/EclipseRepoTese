/**
 * generated by Xtext 2.10.0
 */
package org.rslingo.rsl.rsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ref DEntity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.rslingo.rsl.rsl.RefDEntity#getRefDEntity <em>Ref DEntity</em>}</li>
 * </ul>
 *
 * @see org.rslingo.rsl.rsl.RslPackage#getRefDEntity()
 * @model
 * @generated
 */
public interface RefDEntity extends EObject
{
  /**
   * Returns the value of the '<em><b>Ref DEntity</b></em>' reference list.
   * The list contents are of type {@link org.rslingo.rsl.rsl.DataEntity}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ref DEntity</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ref DEntity</em>' reference list.
   * @see org.rslingo.rsl.rsl.RslPackage#getRefDEntity_RefDEntity()
   * @model
   * @generated
   */
  EList<DataEntity> getRefDEntity();

} // RefDEntity