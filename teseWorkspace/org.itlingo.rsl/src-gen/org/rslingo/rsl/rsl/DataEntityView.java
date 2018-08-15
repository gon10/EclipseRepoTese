/**
 * generated by Xtext 2.10.0
 */
package org.rslingo.rsl.rsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Entity View</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.rslingo.rsl.rsl.DataEntityView#getName <em>Name</em>}</li>
 *   <li>{@link org.rslingo.rsl.rsl.DataEntityView#getType <em>Type</em>}</li>
 *   <li>{@link org.rslingo.rsl.rsl.DataEntityView#getNameAlias <em>Name Alias</em>}</li>
 *   <li>{@link org.rslingo.rsl.rsl.DataEntityView#getMaster <em>Master</em>}</li>
 *   <li>{@link org.rslingo.rsl.rsl.DataEntityView#getDetails <em>Details</em>}</li>
 *   <li>{@link org.rslingo.rsl.rsl.DataEntityView#getReferences <em>References</em>}</li>
 *   <li>{@link org.rslingo.rsl.rsl.DataEntityView#getDescription <em>Description</em>}</li>
 * </ul>
 *
 * @see org.rslingo.rsl.rsl.RslPackage#getDataEntityView()
 * @model
 * @generated
 */
public interface DataEntityView extends EObject
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
   * @see org.rslingo.rsl.rsl.RslPackage#getDataEntityView_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.rslingo.rsl.rsl.DataEntityView#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * The literals are from the enumeration {@link org.rslingo.rsl.rsl.DataEntityViewType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' attribute.
   * @see org.rslingo.rsl.rsl.DataEntityViewType
   * @see #setType(DataEntityViewType)
   * @see org.rslingo.rsl.rsl.RslPackage#getDataEntityView_Type()
   * @model
   * @generated
   */
  DataEntityViewType getType();

  /**
   * Sets the value of the '{@link org.rslingo.rsl.rsl.DataEntityView#getType <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see org.rslingo.rsl.rsl.DataEntityViewType
   * @see #getType()
   * @generated
   */
  void setType(DataEntityViewType value);

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
   * @see org.rslingo.rsl.rsl.RslPackage#getDataEntityView_NameAlias()
   * @model
   * @generated
   */
  String getNameAlias();

  /**
   * Sets the value of the '{@link org.rslingo.rsl.rsl.DataEntityView#getNameAlias <em>Name Alias</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name Alias</em>' attribute.
   * @see #getNameAlias()
   * @generated
   */
  void setNameAlias(String value);

  /**
   * Returns the value of the '<em><b>Master</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Master</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Master</em>' containment reference.
   * @see #setMaster(MasterDEntity)
   * @see org.rslingo.rsl.rsl.RslPackage#getDataEntityView_Master()
   * @model containment="true"
   * @generated
   */
  MasterDEntity getMaster();

  /**
   * Sets the value of the '{@link org.rslingo.rsl.rsl.DataEntityView#getMaster <em>Master</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Master</em>' containment reference.
   * @see #getMaster()
   * @generated
   */
  void setMaster(MasterDEntity value);

  /**
   * Returns the value of the '<em><b>Details</b></em>' containment reference list.
   * The list contents are of type {@link org.rslingo.rsl.rsl.DetailDEntity}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Details</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Details</em>' containment reference list.
   * @see org.rslingo.rsl.rsl.RslPackage#getDataEntityView_Details()
   * @model containment="true"
   * @generated
   */
  EList<DetailDEntity> getDetails();

  /**
   * Returns the value of the '<em><b>References</b></em>' containment reference list.
   * The list contents are of type {@link org.rslingo.rsl.rsl.ReferenceDEntity}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>References</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>References</em>' containment reference list.
   * @see org.rslingo.rsl.rsl.RslPackage#getDataEntityView_References()
   * @model containment="true"
   * @generated
   */
  EList<ReferenceDEntity> getReferences();

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
   * @see org.rslingo.rsl.rsl.RslPackage#getDataEntityView_Description()
   * @model
   * @generated
   */
  String getDescription();

  /**
   * Sets the value of the '{@link org.rslingo.rsl.rsl.DataEntityView#getDescription <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Description</em>' attribute.
   * @see #getDescription()
   * @generated
   */
  void setDescription(String value);

} // DataEntityView