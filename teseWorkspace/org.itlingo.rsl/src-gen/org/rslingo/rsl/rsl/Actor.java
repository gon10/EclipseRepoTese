/**
 * generated by Xtext 2.10.0
 */
package org.rslingo.rsl.rsl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Actor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.rslingo.rsl.rsl.Actor#getName <em>Name</em>}</li>
 *   <li>{@link org.rslingo.rsl.rsl.Actor#getType <em>Type</em>}</li>
 *   <li>{@link org.rslingo.rsl.rsl.Actor#getNameAlias <em>Name Alias</em>}</li>
 *   <li>{@link org.rslingo.rsl.rsl.Actor#getSuper <em>Super</em>}</li>
 *   <li>{@link org.rslingo.rsl.rsl.Actor#getDescription <em>Description</em>}</li>
 * </ul>
 *
 * @see org.rslingo.rsl.rsl.RslPackage#getActor()
 * @model
 * @generated
 */
public interface Actor extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.rslingo.rsl.rsl.RslPackage#getActor_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.rslingo.rsl.rsl.Actor#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * The literals are from the enumeration {@link org.rslingo.rsl.rsl.ActorType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' attribute.
   * @see org.rslingo.rsl.rsl.ActorType
   * @see #setType(ActorType)
   * @see org.rslingo.rsl.rsl.RslPackage#getActor_Type()
   * @model
   * @generated
   */
  ActorType getType();

  /**
   * Sets the value of the '{@link org.rslingo.rsl.rsl.Actor#getType <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see org.rslingo.rsl.rsl.ActorType
   * @see #getType()
   * @generated
   */
  void setType(ActorType value);

  /**
   * Returns the value of the '<em><b>Name Alias</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name Alias</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name Alias</em>' attribute.
   * @see #setNameAlias(String)
   * @see org.rslingo.rsl.rsl.RslPackage#getActor_NameAlias()
   * @model
   * @generated
   */
  String getNameAlias();

  /**
   * Sets the value of the '{@link org.rslingo.rsl.rsl.Actor#getNameAlias <em>Name Alias</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name Alias</em>' attribute.
   * @see #getNameAlias()
   * @generated
   */
  void setNameAlias(String value);

  /**
   * Returns the value of the '<em><b>Super</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Super</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Super</em>' reference.
   * @see #setSuper(Actor)
   * @see org.rslingo.rsl.rsl.RslPackage#getActor_Super()
   * @model
   * @generated
   */
  Actor getSuper();

  /**
   * Sets the value of the '{@link org.rslingo.rsl.rsl.Actor#getSuper <em>Super</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Super</em>' reference.
   * @see #getSuper()
   * @generated
   */
  void setSuper(Actor value);

  /**
   * Returns the value of the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Description</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Description</em>' attribute.
   * @see #setDescription(String)
   * @see org.rslingo.rsl.rsl.RslPackage#getActor_Description()
   * @model
   * @generated
   */
  String getDescription();

  /**
   * Sets the value of the '{@link org.rslingo.rsl.rsl.Actor#getDescription <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Description</em>' attribute.
   * @see #getDescription()
   * @generated
   */
  void setDescription(String value);

} // Actor
