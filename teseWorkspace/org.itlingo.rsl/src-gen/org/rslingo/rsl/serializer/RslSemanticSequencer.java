/*
 * generated by Xtext 2.10.0
 */
package org.rslingo.rsl.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import org.rslingo.rsl.rsl.Actor;
import org.rslingo.rsl.rsl.Attribute;
import org.rslingo.rsl.rsl.Check;
import org.rslingo.rsl.rsl.DataEntity;
import org.rslingo.rsl.rsl.DataEntityView;
import org.rslingo.rsl.rsl.Date;
import org.rslingo.rsl.rsl.DetailDEntity;
import org.rslingo.rsl.rsl.ForeignKey;
import org.rslingo.rsl.rsl.IfStep;
import org.rslingo.rsl.rsl.Import;
import org.rslingo.rsl.rsl.MasterDEntity;
import org.rslingo.rsl.rsl.Model;
import org.rslingo.rsl.rsl.Month;
import org.rslingo.rsl.rsl.Multiplicity;
import org.rslingo.rsl.rsl.PackageSystem;
import org.rslingo.rsl.rsl.PrimaryKey;
import org.rslingo.rsl.rsl.RefActor;
import org.rslingo.rsl.rsl.RefAttribute;
import org.rslingo.rsl.rsl.RefDEntity;
import org.rslingo.rsl.rsl.RefSystem;
import org.rslingo.rsl.rsl.RefUC;
import org.rslingo.rsl.rsl.RefUCAction;
import org.rslingo.rsl.rsl.ReferenceDEntity;
import org.rslingo.rsl.rsl.RequirementRelation;
import org.rslingo.rsl.rsl.RslPackage;
import org.rslingo.rsl.rsl.Scenario;
import org.rslingo.rsl.rsl.SimpleStep;
import org.rslingo.rsl.rsl.State;
import org.rslingo.rsl.rsl.StateMachine;
import org.rslingo.rsl.rsl.Step;
import org.rslingo.rsl.rsl.SystemRelation;
import org.rslingo.rsl.rsl.UCAction;
import org.rslingo.rsl.rsl.UCActions;
import org.rslingo.rsl.rsl.UCExtends;
import org.rslingo.rsl.rsl.UCExtensionPoint;
import org.rslingo.rsl.rsl.UCExtensionPoints;
import org.rslingo.rsl.rsl.UCIncludes;
import org.rslingo.rsl.rsl.UseCase;
import org.rslingo.rsl.services.RslGrammarAccess;

@SuppressWarnings("all")
public class RslSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private RslGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == RslPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case RslPackage.ACTOR:
				sequence_Actor(context, (Actor) semanticObject); 
				return; 
			case RslPackage.ATTRIBUTE:
				sequence_Attribute(context, (Attribute) semanticObject); 
				return; 
			case RslPackage.CHECK:
				sequence_Check(context, (Check) semanticObject); 
				return; 
			case RslPackage.DATA_ENTITY:
				sequence_DataEntity(context, (DataEntity) semanticObject); 
				return; 
			case RslPackage.DATA_ENTITY_VIEW:
				sequence_DataEntityView(context, (DataEntityView) semanticObject); 
				return; 
			case RslPackage.DATE:
				sequence_Date(context, (Date) semanticObject); 
				return; 
			case RslPackage.DETAIL_DENTITY:
				sequence_DetailDEntity(context, (DetailDEntity) semanticObject); 
				return; 
			case RslPackage.FOREIGN_KEY:
				sequence_ForeignKey(context, (ForeignKey) semanticObject); 
				return; 
			case RslPackage.IF_STEP:
				sequence_IfStep(context, (IfStep) semanticObject); 
				return; 
			case RslPackage.IMPORT:
				sequence_Import(context, (Import) semanticObject); 
				return; 
			case RslPackage.MASTER_DENTITY:
				sequence_MasterDEntity(context, (MasterDEntity) semanticObject); 
				return; 
			case RslPackage.MODEL:
				sequence_Model(context, (Model) semanticObject); 
				return; 
			case RslPackage.MONTH:
				sequence_Month(context, (Month) semanticObject); 
				return; 
			case RslPackage.MULTIPLICITY:
				sequence_Multiplicity(context, (Multiplicity) semanticObject); 
				return; 
			case RslPackage.PACKAGE_SYSTEM:
				sequence_PackageSystem(context, (PackageSystem) semanticObject); 
				return; 
			case RslPackage.PRIMARY_KEY:
				sequence_PrimaryKey(context, (PrimaryKey) semanticObject); 
				return; 
			case RslPackage.REF_ACTOR:
				sequence_RefActor(context, (RefActor) semanticObject); 
				return; 
			case RslPackage.REF_ATTRIBUTE:
				sequence_RefAttribute(context, (RefAttribute) semanticObject); 
				return; 
			case RslPackage.REF_DENTITY:
				sequence_RefDEntity(context, (RefDEntity) semanticObject); 
				return; 
			case RslPackage.REF_SYSTEM:
				sequence_RefSystem(context, (RefSystem) semanticObject); 
				return; 
			case RslPackage.REF_UC:
				sequence_RefUC(context, (RefUC) semanticObject); 
				return; 
			case RslPackage.REF_UC_ACTION:
				sequence_RefUCAction(context, (RefUCAction) semanticObject); 
				return; 
			case RslPackage.REFERENCE_DENTITY:
				sequence_ReferenceDEntity(context, (ReferenceDEntity) semanticObject); 
				return; 
			case RslPackage.REQUIREMENT_RELATION:
				sequence_RequirementRelation(context, (RequirementRelation) semanticObject); 
				return; 
			case RslPackage.SCENARIO:
				sequence_Scenario(context, (Scenario) semanticObject); 
				return; 
			case RslPackage.SIMPLE_STEP:
				sequence_SimpleStep(context, (SimpleStep) semanticObject); 
				return; 
			case RslPackage.STATE:
				if (rule == grammarAccess.getStateRule()) {
					sequence_State(context, (State) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getStatesRule()) {
					sequence_States(context, (State) semanticObject); 
					return; 
				}
				else break;
			case RslPackage.STATE_MACHINE:
				sequence_StateMachine(context, (StateMachine) semanticObject); 
				return; 
			case RslPackage.STEP:
				sequence_Step(context, (Step) semanticObject); 
				return; 
			case RslPackage.SYSTEM:
				sequence_System(context, (org.rslingo.rsl.rsl.System) semanticObject); 
				return; 
			case RslPackage.SYSTEM_RELATION:
				sequence_SystemRelation(context, (SystemRelation) semanticObject); 
				return; 
			case RslPackage.UC_ACTION:
				sequence_UCAction(context, (UCAction) semanticObject); 
				return; 
			case RslPackage.UC_ACTIONS:
				sequence_UCActions(context, (UCActions) semanticObject); 
				return; 
			case RslPackage.UC_EXTENDS:
				sequence_UCExtends(context, (UCExtends) semanticObject); 
				return; 
			case RslPackage.UC_EXTENSION_POINT:
				sequence_UCExtensionPoint(context, (UCExtensionPoint) semanticObject); 
				return; 
			case RslPackage.UC_EXTENSION_POINTS:
				sequence_UCExtensionPoints(context, (UCExtensionPoints) semanticObject); 
				return; 
			case RslPackage.UC_INCLUDES:
				sequence_UCIncludes(context, (UCIncludes) semanticObject); 
				return; 
			case RslPackage.USE_CASE:
				sequence_UseCase(context, (UseCase) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     Actor returns Actor
	 *
	 * Constraint:
	 *     (name=ID type=ActorType nameAlias=STRING super=[Actor|ID]? description=STRING?)
	 */
	protected void sequence_Actor(ISerializationContext context, Actor semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Attribute returns Attribute
	 *
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         type=AttributeType 
	 *         size=DoubleOrInt? 
	 *         nameAlias=STRING 
	 *         multiplicity=Multiplicity? 
	 *         defaultValue=STRING? 
	 *         values=STRING? 
	 *         notNull='NotNull'? 
	 *         unique='Unique'? 
	 *         description=STRING?
	 *     )
	 */
	protected void sequence_Attribute(ISerializationContext context, Attribute semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Check returns Check
	 *
	 * Constraint:
	 *     (name=ID checkExpression=STRING)
	 */
	protected void sequence_Check(ISerializationContext context, Check semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, RslPackage.Literals.CHECK__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RslPackage.Literals.CHECK__NAME));
			if (transientValues.isValueTransient(semanticObject, RslPackage.Literals.CHECK__CHECK_EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RslPackage.Literals.CHECK__CHECK_EXPRESSION));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getCheckAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getCheckAccess().getCheckExpressionSTRINGTerminalRuleCall_2_0(), semanticObject.getCheckExpression());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     DataEntityView returns DataEntityView
	 *
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         type=DataEntityViewType 
	 *         nameAlias=STRING 
	 *         master=MasterDEntity 
	 *         details+=DetailDEntity* 
	 *         references+=ReferenceDEntity* 
	 *         description=STRING?
	 *     )
	 */
	protected void sequence_DataEntityView(ISerializationContext context, DataEntityView semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     DataEntity returns DataEntity
	 *
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         type=DataEntityType 
	 *         subType=DataEntitySubType? 
	 *         nameAlias=STRING 
	 *         super=[DataEntity|ID]? 
	 *         attributes+=Attribute+ 
	 *         primaryKey=PrimaryKey? 
	 *         foreignKeys+=ForeignKey* 
	 *         checks+=Check* 
	 *         description=STRING?
	 *     )
	 */
	protected void sequence_DataEntity(ISerializationContext context, DataEntity semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Date returns Date
	 *
	 * Constraint:
	 *     (day=INT month=Month year=INT)
	 */
	protected void sequence_Date(ISerializationContext context, Date semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, RslPackage.Literals.DATE__DAY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RslPackage.Literals.DATE__DAY));
			if (transientValues.isValueTransient(semanticObject, RslPackage.Literals.DATE__MONTH) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RslPackage.Literals.DATE__MONTH));
			if (transientValues.isValueTransient(semanticObject, RslPackage.Literals.DATE__YEAR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RslPackage.Literals.DATE__YEAR));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getDateAccess().getDayINTTerminalRuleCall_0_0(), semanticObject.getDay());
		feeder.accept(grammarAccess.getDateAccess().getMonthMonthParserRuleCall_2_0(), semanticObject.getMonth());
		feeder.accept(grammarAccess.getDateAccess().getYearINTTerminalRuleCall_4_0(), semanticObject.getYear());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     DetailDEntity returns DetailDEntity
	 *
	 * Constraint:
	 *     (dEntityDetail=[DataEntity|ID] refDEntity=RefDEntity?)
	 */
	protected void sequence_DetailDEntity(ISerializationContext context, DetailDEntity semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ForeignKey returns ForeignKey
	 *
	 * Constraint:
	 *     (fentity=[DataEntity|ID] refTo=RefAttribute)
	 */
	protected void sequence_ForeignKey(ISerializationContext context, ForeignKey semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, RslPackage.Literals.FOREIGN_KEY__FENTITY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RslPackage.Literals.FOREIGN_KEY__FENTITY));
			if (transientValues.isValueTransient(semanticObject, RslPackage.Literals.FOREIGN_KEY__REF_TO) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RslPackage.Literals.FOREIGN_KEY__REF_TO));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getForeignKeyAccess().getFentityDataEntityIDTerminalRuleCall_1_0_1(), semanticObject.getFentity());
		feeder.accept(grammarAccess.getForeignKeyAccess().getRefToRefAttributeParserRuleCall_3_0(), semanticObject.getRefTo());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     IfStep returns IfStep
	 *
	 * Constraint:
	 *     (action=[UCAction|QualifiedName] steps+=Step+)
	 */
	protected void sequence_IfStep(ISerializationContext context, IfStep semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Import returns Import
	 *
	 * Constraint:
	 *     importedNamespace=QualifiedNameWithWildcard
	 */
	protected void sequence_Import(ISerializationContext context, Import semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, RslPackage.Literals.IMPORT__IMPORTED_NAMESPACE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RslPackage.Literals.IMPORT__IMPORTED_NAMESPACE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_0(), semanticObject.getImportedNamespace());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     MasterDEntity returns MasterDEntity
	 *
	 * Constraint:
	 *     masterDEntity=[DataEntity|ID]
	 */
	protected void sequence_MasterDEntity(ISerializationContext context, MasterDEntity semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, RslPackage.Literals.MASTER_DENTITY__MASTER_DENTITY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RslPackage.Literals.MASTER_DENTITY__MASTER_DENTITY));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getMasterDEntityAccess().getMasterDEntityDataEntityIDTerminalRuleCall_1_0_1(), semanticObject.getMasterDEntity());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Model returns Model
	 *
	 * Constraint:
	 *     packages+=PackageAbstract+
	 */
	protected void sequence_Model(ISerializationContext context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Month returns Month
	 *
	 * Constraint:
	 *     (
	 *         value='Jan' | 
	 *         value='Feb' | 
	 *         value='Mar' | 
	 *         value='Apr' | 
	 *         value='May' | 
	 *         value='Jun' | 
	 *         value='Jul' | 
	 *         value='Aug' | 
	 *         value='Sep' | 
	 *         value='Oct' | 
	 *         value='Nov' | 
	 *         value='Dec'
	 *     )
	 */
	protected void sequence_Month(ISerializationContext context, Month semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Multiplicity returns Multiplicity
	 *
	 * Constraint:
	 *     (value='"0"' | value='"1"' | value='"0..1"' | value='"*"' | value=STRING)
	 */
	protected void sequence_Multiplicity(ISerializationContext context, Multiplicity semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     PackageAbstract returns PackageSystem
	 *     PackageSystem returns PackageSystem
	 *
	 * Constraint:
	 *     (
	 *         name=QualifiedName 
	 *         imports+=Import* 
	 *         system=System 
	 *         entities+=DataEntity* 
	 *         dataEntityViews+=DataEntityView* 
	 *         actors+=Actor* 
	 *         requirements+=Requirement* 
	 *         stateMachine+=StateMachine* 
	 *         requirementRelations+=RequirementRelation*
	 *     )
	 */
	protected void sequence_PackageSystem(ISerializationContext context, PackageSystem semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     PrimaryKey returns PrimaryKey
	 *
	 * Constraint:
	 *     refTo=RefAttribute
	 */
	protected void sequence_PrimaryKey(ISerializationContext context, PrimaryKey semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, RslPackage.Literals.PRIMARY_KEY__REF_TO) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RslPackage.Literals.PRIMARY_KEY__REF_TO));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getPrimaryKeyAccess().getRefToRefAttributeParserRuleCall_2_0(), semanticObject.getRefTo());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     RefActor returns RefActor
	 *
	 * Constraint:
	 *     (refs+=[Actor|ID] refs+=[Actor|ID]*)
	 */
	protected void sequence_RefActor(ISerializationContext context, RefActor semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     RefAttribute returns RefAttribute
	 *
	 * Constraint:
	 *     (refAttr+=[Attribute|ID] refAttr+=[Attribute|ID]*)
	 */
	protected void sequence_RefAttribute(ISerializationContext context, RefAttribute semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     RefDEntity returns RefDEntity
	 *
	 * Constraint:
	 *     (refDEntity+=[DataEntity|ID] refDEntity+=[DataEntity|ID]*)
	 */
	protected void sequence_RefDEntity(ISerializationContext context, RefDEntity semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     RefSystem returns RefSystem
	 *
	 * Constraint:
	 *     (refs+=[System|ID] refs+=[System|ID]*)
	 */
	protected void sequence_RefSystem(ISerializationContext context, RefSystem semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     RefUCAction returns RefUCAction
	 *
	 * Constraint:
	 *     (action=[UCAction|QualifiedName] nextstate=[State|ID]?)
	 */
	protected void sequence_RefUCAction(ISerializationContext context, RefUCAction semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     RefUC returns RefUC
	 *
	 * Constraint:
	 *     (refs+=[UseCase|ID] refs+=[UseCase|ID]*)
	 */
	protected void sequence_RefUC(ISerializationContext context, RefUC semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ReferenceDEntity returns ReferenceDEntity
	 *
	 * Constraint:
	 *     refDEntity=RefDEntity
	 */
	protected void sequence_ReferenceDEntity(ISerializationContext context, ReferenceDEntity semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, RslPackage.Literals.REFERENCE_DENTITY__REF_DENTITY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RslPackage.Literals.REFERENCE_DENTITY__REF_DENTITY));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getReferenceDEntityAccess().getRefDEntityRefDEntityParserRuleCall_1_0(), semanticObject.getRefDEntity());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     RequirementRelation returns RequirementRelation
	 *
	 * Constraint:
	 *     (name=ID type=RequirementRelationType source=[Requirement|ID] target=[Requirement|ID] description=STRING?)
	 */
	protected void sequence_RequirementRelation(ISerializationContext context, RequirementRelation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Scenario returns Scenario
	 *
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         type=ScenarioType 
	 *         nameAlias=STRING 
	 *         (mode='Sequential' | mode='Parallel')? 
	 *         description=STRING? 
	 *         steps+=Step*
	 *     )
	 */
	protected void sequence_Scenario(ISerializationContext context, Scenario semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     SimpleStep returns SimpleStep
	 *
	 * Constraint:
	 *     (
	 *         nameAlias=STRING 
	 *         actor=[Actor|ID]? 
	 *         description=STRING? 
	 *         precondition=STRING? 
	 *         postcondition=STRING? 
	 *         next=[Step|ID]?
	 *     )
	 */
	protected void sequence_SimpleStep(ISerializationContext context, SimpleStep semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     StateMachine returns StateMachine
	 *
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         type=StateMachineType 
	 *         nameAlias=STRING 
	 *         entity=[DataEntity|ID] 
	 *         description=STRING? 
	 *         states=States
	 *     )
	 */
	protected void sequence_StateMachine(ISerializationContext context, StateMachine semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     State returns State
	 *
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         isInitial?='isInitial'? 
	 *         isFinal?='isFinal'? 
	 *         onEntry=STRING? 
	 *         onExit=STRING? 
	 *         actions+=RefUCAction? 
	 *         actions+=RefUCAction*
	 *     )
	 */
	protected void sequence_State(ISerializationContext context, State semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     States returns State
	 *
	 * Constraint:
	 *     states+=State*
	 */
	protected void sequence_States(ISerializationContext context, State semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Step returns Step
	 *
	 * Constraint:
	 *     (name=ID type=StepOperationType subType=StepOperationSubType? (simpleStep=SimpleStep | subSteps+=Step+ | ifSteps+=IfStep+)?)
	 */
	protected void sequence_Step(ISerializationContext context, Step semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     SystemRelation returns SystemRelation
	 *
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         type=SystemRelationType 
	 *         source=[System|ID] 
	 *         target=[System|ID] 
	 *         category=SystemRelationCategory 
	 *         description=STRING?
	 *     )
	 */
	protected void sequence_SystemRelation(ISerializationContext context, SystemRelation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     System returns System
	 *
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         type=SystemType 
	 *         nameAlias=STRING 
	 *         scope=SystemScope? 
	 *         subSystems=RefSystem? 
	 *         reusableSystems=RefSystem? 
	 *         description=STRING?
	 *     )
	 */
	protected void sequence_System(ISerializationContext context, org.rslingo.rsl.rsl.System semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     UCAction returns UCAction
	 *
	 * Constraint:
	 *     (name=ID description=STRING?)
	 */
	protected void sequence_UCAction(ISerializationContext context, UCAction semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     UCActions returns UCActions
	 *
	 * Constraint:
	 *     (actions+=UCAction actions+=UCAction*)
	 */
	protected void sequence_UCActions(ISerializationContext context, UCActions semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     UCExtends returns UCExtends
	 *
	 * Constraint:
	 *     (usecase=[UseCase|ID] extensionPoint=[UCExtensionPoint|QualifiedName])
	 */
	protected void sequence_UCExtends(ISerializationContext context, UCExtends semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, RslPackage.Literals.UC_EXTENDS__USECASE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RslPackage.Literals.UC_EXTENDS__USECASE));
			if (transientValues.isValueTransient(semanticObject, RslPackage.Literals.UC_EXTENDS__EXTENSION_POINT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RslPackage.Literals.UC_EXTENDS__EXTENSION_POINT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getUCExtendsAccess().getUsecaseUseCaseIDTerminalRuleCall_1_0_1(), semanticObject.getUsecase());
		feeder.accept(grammarAccess.getUCExtendsAccess().getExtensionPointUCExtensionPointQualifiedNameParserRuleCall_3_0_1(), semanticObject.getExtensionPoint());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     UCExtensionPoint returns UCExtensionPoint
	 *
	 * Constraint:
	 *     (name=ID description=STRING?)
	 */
	protected void sequence_UCExtensionPoint(ISerializationContext context, UCExtensionPoint semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     UCExtensionPoints returns UCExtensionPoints
	 *
	 * Constraint:
	 *     (extensionPoints+=UCExtensionPoint extensionPoints+=UCExtensionPoint*)
	 */
	protected void sequence_UCExtensionPoints(ISerializationContext context, UCExtensionPoints semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     UCIncludes returns UCIncludes
	 *
	 * Constraint:
	 *     includes+=RefUC
	 */
	protected void sequence_UCIncludes(ISerializationContext context, UCIncludes semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Requirement returns UseCase
	 *     SystemRequirement returns UseCase
	 *     UseCase returns UseCase
	 *
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         type=UseCaseType 
	 *         nameAlias=STRING 
	 *         actorInitiates=[Actor|ID] 
	 *         actorParticipates+=RefActor? 
	 *         dEntityView=[DataEntityView|ID]? 
	 *         precondition=STRING? 
	 *         postcondition=STRING? 
	 *         actions=UCActions? 
	 *         extensionPoints=UCExtensionPoints? 
	 *         includes=UCIncludes? 
	 *         extends+=UCExtends* 
	 *         priority=PriorityType? 
	 *         description=STRING? 
	 *         scenarios+=Scenario*
	 *     )
	 */
	protected void sequence_UseCase(ISerializationContext context, UseCase semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}