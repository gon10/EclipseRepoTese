package org.rslingo.rsl.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.rslingo.rsl.services.RslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalRslParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_DOUBLE", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'.'", "'.*'", "'import'", "'Jan'", "'Feb'", "'Mar'", "'Apr'", "'May'", "'Jun'", "'Jul'", "'Aug'", "'Sep'", "'Oct'", "'Nov'", "'Dec'", "'package-system'", "'system'", "':'", "'['", "'name'", "'scope'", "'subSystems'", "'reusableSystems'", "'description'", "']'", "','", "'dataEntity'", "'isA'", "'attribute'", "'('", "')'", "'multiplicity'", "'defaultValue'", "'values'", "'NotNull'", "'Unique'", "'\"0\"'", "'\"1\"'", "'\"0..1\"'", "'\"*\"'", "'primaryKey'", "'foreignKey'", "'check'", "'dataEntityView'", "'master'", "'detail'", "'reference'", "'actor'", "'requirementRelation'", "'source'", "'target'", "'useCase'", "'actorInitiates'", "'actorParticipates'", "'precondition'", "'postcondition'", "'priority'", "'actions'", "'includes'", "'extends'", "'onExtensionPoint'", "'extensionPoints'", "'scenario'", "'executionMode'", "'Sequential'", "'Parallel'", "'step'", "'nextStep'", "'ifAction'", "'stateMachine'", "'state'", "'isInitial'", "'isFinal'", "'onEntry'", "'onExit'", "'useCaseAction'", "'nextState'", "'System'", "'SubSystem'", "'ReusableSystem'", "'Application'", "'Other'", "'In'", "'Out'", "'Requires'", "'Supports'", "'Obstructs'", "'Conflicts'", "'Identical'", "'Relates'", "'Import'", "'Export'", "'ImportExport'", "'Sync'", "'Interact'", "'Principal'", "'Secondary'", "'Simple'", "'Complex'", "'Integer'", "'Double'", "'Decimal'", "'Boolean'", "'Bit'", "'Currency'", "'Date'", "'Time'", "'Datetime'", "'String'", "'Text'", "'Regex'", "'URL'", "'Image'", "'XML'", "'Binary'", "'VerySimple'", "'User'", "'ExternalSystem'", "'Timer'", "'Must'", "'Should'", "'Could'", "'WillNot'", "'EntityCreate'", "'EntityRead'", "'EntityUpdate'", "'EntityDelete'", "'EntityReport'", "'EntityDashboard'", "'EntityOther'", "'EntitiesManage'", "'EntitiesBrowse'", "'EntitiesSearch'", "'EntitiesReport'", "'EntitiesDashboard'", "'EntitiesInteropImport'", "'EntitiesInteropExport'", "'EntitiesInteropSync'", "'EntitiesInteropSendMessage'", "'EntitiesInteropServiceInvocation'", "'EntitiesMapShow'", "'EntitiesMapInteract'", "'EntitiesOther'", "'Main'", "'Alternative'", "'Exception'", "'Actor_PrepareData'", "'Actor_CallSystem'", "'System_Executes'", "'System_ReturnResult'", "'None'", "'SubmitData'", "'ShowData'", "'CancelUseCase'", "'TerminateUseCase'"
    };
    public static final int T__144=144;
    public static final int T__143=143;
    public static final int T__146=146;
    public static final int T__50=50;
    public static final int T__145=145;
    public static final int T__140=140;
    public static final int T__142=142;
    public static final int T__141=141;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__137=137;
    public static final int T__52=52;
    public static final int T__136=136;
    public static final int T__53=53;
    public static final int T__139=139;
    public static final int T__54=54;
    public static final int T__138=138;
    public static final int T__133=133;
    public static final int T__132=132;
    public static final int T__60=60;
    public static final int T__135=135;
    public static final int T__61=61;
    public static final int T__134=134;
    public static final int RULE_ID=4;
    public static final int T__131=131;
    public static final int T__130=130;
    public static final int RULE_INT=6;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__67=67;
    public static final int T__129=129;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__126=126;
    public static final int T__63=63;
    public static final int T__125=125;
    public static final int T__64=64;
    public static final int T__128=128;
    public static final int T__65=65;
    public static final int T__127=127;
    public static final int T__166=166;
    public static final int T__165=165;
    public static final int T__162=162;
    public static final int T__161=161;
    public static final int T__164=164;
    public static final int T__163=163;
    public static final int T__160=160;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__159=159;
    public static final int T__30=30;
    public static final int T__158=158;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__155=155;
    public static final int T__154=154;
    public static final int T__157=157;
    public static final int T__156=156;
    public static final int T__151=151;
    public static final int T__150=150;
    public static final int T__153=153;
    public static final int T__152=152;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__148=148;
    public static final int T__41=41;
    public static final int T__147=147;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__149=149;
    public static final int T__91=91;
    public static final int T__100=100;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__102=102;
    public static final int T__94=94;
    public static final int T__101=101;
    public static final int T__90=90;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__99=99;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__122=122;
    public static final int T__70=70;
    public static final int T__121=121;
    public static final int T__71=71;
    public static final int T__124=124;
    public static final int T__72=72;
    public static final int T__123=123;
    public static final int T__120=120;
    public static final int RULE_STRING=7;
    public static final int RULE_SL_COMMENT=9;
    public static final int RULE_DOUBLE=5;
    public static final int T__77=77;
    public static final int T__119=119;
    public static final int T__78=78;
    public static final int T__118=118;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int T__115=115;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__114=114;
    public static final int T__75=75;
    public static final int T__117=117;
    public static final int T__76=76;
    public static final int T__116=116;
    public static final int T__80=80;
    public static final int T__111=111;
    public static final int T__81=81;
    public static final int T__110=110;
    public static final int T__82=82;
    public static final int T__113=113;
    public static final int T__83=83;
    public static final int T__112=112;
    public static final int RULE_WS=10;
    public static final int RULE_ANY_OTHER=11;
    public static final int T__88=88;
    public static final int T__108=108;
    public static final int T__89=89;
    public static final int T__107=107;
    public static final int T__109=109;
    public static final int T__84=84;
    public static final int T__104=104;
    public static final int T__85=85;
    public static final int T__103=103;
    public static final int T__86=86;
    public static final int T__106=106;
    public static final int T__87=87;
    public static final int T__105=105;

    // delegates
    // delegators


        public InternalRslParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalRslParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalRslParser.tokenNames; }
    public String getGrammarFileName() { return "InternalRsl.g"; }



     	private RslGrammarAccess grammarAccess;

        public InternalRslParser(TokenStream input, RslGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Model";
       	}

       	@Override
       	protected RslGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleModel"
    // InternalRsl.g:65:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalRsl.g:65:46: (iv_ruleModel= ruleModel EOF )
            // InternalRsl.g:66:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalRsl.g:72:1: ruleModel returns [EObject current=null] : ( (lv_packages_0_0= rulePackageAbstract ) )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_packages_0_0 = null;



        	enterRule();

        try {
            // InternalRsl.g:78:2: ( ( (lv_packages_0_0= rulePackageAbstract ) )* )
            // InternalRsl.g:79:2: ( (lv_packages_0_0= rulePackageAbstract ) )*
            {
            // InternalRsl.g:79:2: ( (lv_packages_0_0= rulePackageAbstract ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==27) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalRsl.g:80:3: (lv_packages_0_0= rulePackageAbstract )
            	    {
            	    // InternalRsl.g:80:3: (lv_packages_0_0= rulePackageAbstract )
            	    // InternalRsl.g:81:4: lv_packages_0_0= rulePackageAbstract
            	    {

            	    				newCompositeNode(grammarAccess.getModelAccess().getPackagesPackageAbstractParserRuleCall_0());
            	    			
            	    pushFollow(FOLLOW_3);
            	    lv_packages_0_0=rulePackageAbstract();

            	    state._fsp--;


            	    				if (current==null) {
            	    					current = createModelElementForParent(grammarAccess.getModelRule());
            	    				}
            	    				add(
            	    					current,
            	    					"packages",
            	    					lv_packages_0_0,
            	    					"org.rslingo.rsl.Rsl.PackageAbstract");
            	    				afterParserOrEnumRuleCall();
            	    			

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRulePackageAbstract"
    // InternalRsl.g:101:1: entryRulePackageAbstract returns [EObject current=null] : iv_rulePackageAbstract= rulePackageAbstract EOF ;
    public final EObject entryRulePackageAbstract() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePackageAbstract = null;


        try {
            // InternalRsl.g:101:56: (iv_rulePackageAbstract= rulePackageAbstract EOF )
            // InternalRsl.g:102:2: iv_rulePackageAbstract= rulePackageAbstract EOF
            {
             newCompositeNode(grammarAccess.getPackageAbstractRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePackageAbstract=rulePackageAbstract();

            state._fsp--;

             current =iv_rulePackageAbstract; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePackageAbstract"


    // $ANTLR start "rulePackageAbstract"
    // InternalRsl.g:108:1: rulePackageAbstract returns [EObject current=null] : this_PackageSystem_0= rulePackageSystem ;
    public final EObject rulePackageAbstract() throws RecognitionException {
        EObject current = null;

        EObject this_PackageSystem_0 = null;



        	enterRule();

        try {
            // InternalRsl.g:114:2: (this_PackageSystem_0= rulePackageSystem )
            // InternalRsl.g:115:2: this_PackageSystem_0= rulePackageSystem
            {

            		newCompositeNode(grammarAccess.getPackageAbstractAccess().getPackageSystemParserRuleCall());
            	
            pushFollow(FOLLOW_2);
            this_PackageSystem_0=rulePackageSystem();

            state._fsp--;


            		current = this_PackageSystem_0;
            		afterParserOrEnumRuleCall();
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePackageAbstract"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalRsl.g:126:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalRsl.g:126:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalRsl.g:127:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // InternalRsl.g:133:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalRsl.g:139:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalRsl.g:140:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalRsl.g:140:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalRsl.g:141:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0());
            		
            // InternalRsl.g:148:3: (kw= '.' this_ID_2= RULE_ID )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==12) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalRsl.g:149:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,12,FOLLOW_5); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_4); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleQualifiedNameWithWildcard"
    // InternalRsl.g:166:1: entryRuleQualifiedNameWithWildcard returns [String current=null] : iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF ;
    public final String entryRuleQualifiedNameWithWildcard() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedNameWithWildcard = null;


        try {
            // InternalRsl.g:166:65: (iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF )
            // InternalRsl.g:167:2: iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameWithWildcardRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedNameWithWildcard=ruleQualifiedNameWithWildcard();

            state._fsp--;

             current =iv_ruleQualifiedNameWithWildcard.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedNameWithWildcard"


    // $ANTLR start "ruleQualifiedNameWithWildcard"
    // InternalRsl.g:173:1: ruleQualifiedNameWithWildcard returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedNameWithWildcard() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_QualifiedName_0 = null;



        	enterRule();

        try {
            // InternalRsl.g:179:2: ( (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? ) )
            // InternalRsl.g:180:2: (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? )
            {
            // InternalRsl.g:180:2: (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? )
            // InternalRsl.g:181:3: this_QualifiedName_0= ruleQualifiedName (kw= '.*' )?
            {

            			newCompositeNode(grammarAccess.getQualifiedNameWithWildcardAccess().getQualifiedNameParserRuleCall_0());
            		
            pushFollow(FOLLOW_6);
            this_QualifiedName_0=ruleQualifiedName();

            state._fsp--;


            			current.merge(this_QualifiedName_0);
            		

            			afterParserOrEnumRuleCall();
            		
            // InternalRsl.g:191:3: (kw= '.*' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==13) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalRsl.g:192:4: kw= '.*'
                    {
                    kw=(Token)match(input,13,FOLLOW_2); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getQualifiedNameWithWildcardAccess().getFullStopAsteriskKeyword_1());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualifiedNameWithWildcard"


    // $ANTLR start "entryRuleImport"
    // InternalRsl.g:202:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // InternalRsl.g:202:47: (iv_ruleImport= ruleImport EOF )
            // InternalRsl.g:203:2: iv_ruleImport= ruleImport EOF
            {
             newCompositeNode(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleImport=ruleImport();

            state._fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // InternalRsl.g:209:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_importedNamespace_1_0 = null;



        	enterRule();

        try {
            // InternalRsl.g:215:2: ( (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) ) ) )
            // InternalRsl.g:216:2: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) ) )
            {
            // InternalRsl.g:216:2: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) ) )
            // InternalRsl.g:217:3: otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) )
            {
            otherlv_0=(Token)match(input,14,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
            		
            // InternalRsl.g:221:3: ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) )
            // InternalRsl.g:222:4: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard )
            {
            // InternalRsl.g:222:4: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard )
            // InternalRsl.g:223:5: lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard
            {

            					newCompositeNode(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_importedNamespace_1_0=ruleQualifiedNameWithWildcard();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getImportRule());
            					}
            					set(
            						current,
            						"importedNamespace",
            						lv_importedNamespace_1_0,
            						"org.rslingo.rsl.Rsl.QualifiedNameWithWildcard");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleDoubleOrInt"
    // InternalRsl.g:244:1: entryRuleDoubleOrInt returns [String current=null] : iv_ruleDoubleOrInt= ruleDoubleOrInt EOF ;
    public final String entryRuleDoubleOrInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDoubleOrInt = null;


        try {
            // InternalRsl.g:244:51: (iv_ruleDoubleOrInt= ruleDoubleOrInt EOF )
            // InternalRsl.g:245:2: iv_ruleDoubleOrInt= ruleDoubleOrInt EOF
            {
             newCompositeNode(grammarAccess.getDoubleOrIntRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDoubleOrInt=ruleDoubleOrInt();

            state._fsp--;

             current =iv_ruleDoubleOrInt.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDoubleOrInt"


    // $ANTLR start "ruleDoubleOrInt"
    // InternalRsl.g:251:1: ruleDoubleOrInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_DOUBLE_0= RULE_DOUBLE | this_INT_1= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleDoubleOrInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_DOUBLE_0=null;
        Token this_INT_1=null;


        	enterRule();

        try {
            // InternalRsl.g:257:2: ( (this_DOUBLE_0= RULE_DOUBLE | this_INT_1= RULE_INT ) )
            // InternalRsl.g:258:2: (this_DOUBLE_0= RULE_DOUBLE | this_INT_1= RULE_INT )
            {
            // InternalRsl.g:258:2: (this_DOUBLE_0= RULE_DOUBLE | this_INT_1= RULE_INT )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_DOUBLE) ) {
                alt4=1;
            }
            else if ( (LA4_0==RULE_INT) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalRsl.g:259:3: this_DOUBLE_0= RULE_DOUBLE
                    {
                    this_DOUBLE_0=(Token)match(input,RULE_DOUBLE,FOLLOW_2); 

                    			current.merge(this_DOUBLE_0);
                    		

                    			newLeafNode(this_DOUBLE_0, grammarAccess.getDoubleOrIntAccess().getDOUBLETerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalRsl.g:267:3: this_INT_1= RULE_INT
                    {
                    this_INT_1=(Token)match(input,RULE_INT,FOLLOW_2); 

                    			current.merge(this_INT_1);
                    		

                    			newLeafNode(this_INT_1, grammarAccess.getDoubleOrIntAccess().getINTTerminalRuleCall_1());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDoubleOrInt"


    // $ANTLR start "entryRuleMonth"
    // InternalRsl.g:278:1: entryRuleMonth returns [EObject current=null] : iv_ruleMonth= ruleMonth EOF ;
    public final EObject entryRuleMonth() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMonth = null;


        try {
            // InternalRsl.g:278:46: (iv_ruleMonth= ruleMonth EOF )
            // InternalRsl.g:279:2: iv_ruleMonth= ruleMonth EOF
            {
             newCompositeNode(grammarAccess.getMonthRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMonth=ruleMonth();

            state._fsp--;

             current =iv_ruleMonth; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMonth"


    // $ANTLR start "ruleMonth"
    // InternalRsl.g:285:1: ruleMonth returns [EObject current=null] : ( ( (lv_value_0_1= 'Jan' | lv_value_0_2= 'Feb' | lv_value_0_3= 'Mar' | lv_value_0_4= 'Apr' | lv_value_0_5= 'May' | lv_value_0_6= 'Jun' | lv_value_0_7= 'Jul' | lv_value_0_8= 'Aug' | lv_value_0_9= 'Sep' | lv_value_0_10= 'Oct' | lv_value_0_11= 'Nov' | lv_value_0_12= 'Dec' ) ) ) ;
    public final EObject ruleMonth() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_1=null;
        Token lv_value_0_2=null;
        Token lv_value_0_3=null;
        Token lv_value_0_4=null;
        Token lv_value_0_5=null;
        Token lv_value_0_6=null;
        Token lv_value_0_7=null;
        Token lv_value_0_8=null;
        Token lv_value_0_9=null;
        Token lv_value_0_10=null;
        Token lv_value_0_11=null;
        Token lv_value_0_12=null;


        	enterRule();

        try {
            // InternalRsl.g:291:2: ( ( ( (lv_value_0_1= 'Jan' | lv_value_0_2= 'Feb' | lv_value_0_3= 'Mar' | lv_value_0_4= 'Apr' | lv_value_0_5= 'May' | lv_value_0_6= 'Jun' | lv_value_0_7= 'Jul' | lv_value_0_8= 'Aug' | lv_value_0_9= 'Sep' | lv_value_0_10= 'Oct' | lv_value_0_11= 'Nov' | lv_value_0_12= 'Dec' ) ) ) )
            // InternalRsl.g:292:2: ( ( (lv_value_0_1= 'Jan' | lv_value_0_2= 'Feb' | lv_value_0_3= 'Mar' | lv_value_0_4= 'Apr' | lv_value_0_5= 'May' | lv_value_0_6= 'Jun' | lv_value_0_7= 'Jul' | lv_value_0_8= 'Aug' | lv_value_0_9= 'Sep' | lv_value_0_10= 'Oct' | lv_value_0_11= 'Nov' | lv_value_0_12= 'Dec' ) ) )
            {
            // InternalRsl.g:292:2: ( ( (lv_value_0_1= 'Jan' | lv_value_0_2= 'Feb' | lv_value_0_3= 'Mar' | lv_value_0_4= 'Apr' | lv_value_0_5= 'May' | lv_value_0_6= 'Jun' | lv_value_0_7= 'Jul' | lv_value_0_8= 'Aug' | lv_value_0_9= 'Sep' | lv_value_0_10= 'Oct' | lv_value_0_11= 'Nov' | lv_value_0_12= 'Dec' ) ) )
            // InternalRsl.g:293:3: ( (lv_value_0_1= 'Jan' | lv_value_0_2= 'Feb' | lv_value_0_3= 'Mar' | lv_value_0_4= 'Apr' | lv_value_0_5= 'May' | lv_value_0_6= 'Jun' | lv_value_0_7= 'Jul' | lv_value_0_8= 'Aug' | lv_value_0_9= 'Sep' | lv_value_0_10= 'Oct' | lv_value_0_11= 'Nov' | lv_value_0_12= 'Dec' ) )
            {
            // InternalRsl.g:293:3: ( (lv_value_0_1= 'Jan' | lv_value_0_2= 'Feb' | lv_value_0_3= 'Mar' | lv_value_0_4= 'Apr' | lv_value_0_5= 'May' | lv_value_0_6= 'Jun' | lv_value_0_7= 'Jul' | lv_value_0_8= 'Aug' | lv_value_0_9= 'Sep' | lv_value_0_10= 'Oct' | lv_value_0_11= 'Nov' | lv_value_0_12= 'Dec' ) )
            // InternalRsl.g:294:4: (lv_value_0_1= 'Jan' | lv_value_0_2= 'Feb' | lv_value_0_3= 'Mar' | lv_value_0_4= 'Apr' | lv_value_0_5= 'May' | lv_value_0_6= 'Jun' | lv_value_0_7= 'Jul' | lv_value_0_8= 'Aug' | lv_value_0_9= 'Sep' | lv_value_0_10= 'Oct' | lv_value_0_11= 'Nov' | lv_value_0_12= 'Dec' )
            {
            // InternalRsl.g:294:4: (lv_value_0_1= 'Jan' | lv_value_0_2= 'Feb' | lv_value_0_3= 'Mar' | lv_value_0_4= 'Apr' | lv_value_0_5= 'May' | lv_value_0_6= 'Jun' | lv_value_0_7= 'Jul' | lv_value_0_8= 'Aug' | lv_value_0_9= 'Sep' | lv_value_0_10= 'Oct' | lv_value_0_11= 'Nov' | lv_value_0_12= 'Dec' )
            int alt5=12;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt5=1;
                }
                break;
            case 16:
                {
                alt5=2;
                }
                break;
            case 17:
                {
                alt5=3;
                }
                break;
            case 18:
                {
                alt5=4;
                }
                break;
            case 19:
                {
                alt5=5;
                }
                break;
            case 20:
                {
                alt5=6;
                }
                break;
            case 21:
                {
                alt5=7;
                }
                break;
            case 22:
                {
                alt5=8;
                }
                break;
            case 23:
                {
                alt5=9;
                }
                break;
            case 24:
                {
                alt5=10;
                }
                break;
            case 25:
                {
                alt5=11;
                }
                break;
            case 26:
                {
                alt5=12;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalRsl.g:295:5: lv_value_0_1= 'Jan'
                    {
                    lv_value_0_1=(Token)match(input,15,FOLLOW_2); 

                    					newLeafNode(lv_value_0_1, grammarAccess.getMonthAccess().getValueJanKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getMonthRule());
                    					}
                    					setWithLastConsumed(current, "value", lv_value_0_1, null);
                    				

                    }
                    break;
                case 2 :
                    // InternalRsl.g:306:5: lv_value_0_2= 'Feb'
                    {
                    lv_value_0_2=(Token)match(input,16,FOLLOW_2); 

                    					newLeafNode(lv_value_0_2, grammarAccess.getMonthAccess().getValueFebKeyword_0_1());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getMonthRule());
                    					}
                    					setWithLastConsumed(current, "value", lv_value_0_2, null);
                    				

                    }
                    break;
                case 3 :
                    // InternalRsl.g:317:5: lv_value_0_3= 'Mar'
                    {
                    lv_value_0_3=(Token)match(input,17,FOLLOW_2); 

                    					newLeafNode(lv_value_0_3, grammarAccess.getMonthAccess().getValueMarKeyword_0_2());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getMonthRule());
                    					}
                    					setWithLastConsumed(current, "value", lv_value_0_3, null);
                    				

                    }
                    break;
                case 4 :
                    // InternalRsl.g:328:5: lv_value_0_4= 'Apr'
                    {
                    lv_value_0_4=(Token)match(input,18,FOLLOW_2); 

                    					newLeafNode(lv_value_0_4, grammarAccess.getMonthAccess().getValueAprKeyword_0_3());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getMonthRule());
                    					}
                    					setWithLastConsumed(current, "value", lv_value_0_4, null);
                    				

                    }
                    break;
                case 5 :
                    // InternalRsl.g:339:5: lv_value_0_5= 'May'
                    {
                    lv_value_0_5=(Token)match(input,19,FOLLOW_2); 

                    					newLeafNode(lv_value_0_5, grammarAccess.getMonthAccess().getValueMayKeyword_0_4());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getMonthRule());
                    					}
                    					setWithLastConsumed(current, "value", lv_value_0_5, null);
                    				

                    }
                    break;
                case 6 :
                    // InternalRsl.g:350:5: lv_value_0_6= 'Jun'
                    {
                    lv_value_0_6=(Token)match(input,20,FOLLOW_2); 

                    					newLeafNode(lv_value_0_6, grammarAccess.getMonthAccess().getValueJunKeyword_0_5());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getMonthRule());
                    					}
                    					setWithLastConsumed(current, "value", lv_value_0_6, null);
                    				

                    }
                    break;
                case 7 :
                    // InternalRsl.g:361:5: lv_value_0_7= 'Jul'
                    {
                    lv_value_0_7=(Token)match(input,21,FOLLOW_2); 

                    					newLeafNode(lv_value_0_7, grammarAccess.getMonthAccess().getValueJulKeyword_0_6());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getMonthRule());
                    					}
                    					setWithLastConsumed(current, "value", lv_value_0_7, null);
                    				

                    }
                    break;
                case 8 :
                    // InternalRsl.g:372:5: lv_value_0_8= 'Aug'
                    {
                    lv_value_0_8=(Token)match(input,22,FOLLOW_2); 

                    					newLeafNode(lv_value_0_8, grammarAccess.getMonthAccess().getValueAugKeyword_0_7());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getMonthRule());
                    					}
                    					setWithLastConsumed(current, "value", lv_value_0_8, null);
                    				

                    }
                    break;
                case 9 :
                    // InternalRsl.g:383:5: lv_value_0_9= 'Sep'
                    {
                    lv_value_0_9=(Token)match(input,23,FOLLOW_2); 

                    					newLeafNode(lv_value_0_9, grammarAccess.getMonthAccess().getValueSepKeyword_0_8());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getMonthRule());
                    					}
                    					setWithLastConsumed(current, "value", lv_value_0_9, null);
                    				

                    }
                    break;
                case 10 :
                    // InternalRsl.g:394:5: lv_value_0_10= 'Oct'
                    {
                    lv_value_0_10=(Token)match(input,24,FOLLOW_2); 

                    					newLeafNode(lv_value_0_10, grammarAccess.getMonthAccess().getValueOctKeyword_0_9());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getMonthRule());
                    					}
                    					setWithLastConsumed(current, "value", lv_value_0_10, null);
                    				

                    }
                    break;
                case 11 :
                    // InternalRsl.g:405:5: lv_value_0_11= 'Nov'
                    {
                    lv_value_0_11=(Token)match(input,25,FOLLOW_2); 

                    					newLeafNode(lv_value_0_11, grammarAccess.getMonthAccess().getValueNovKeyword_0_10());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getMonthRule());
                    					}
                    					setWithLastConsumed(current, "value", lv_value_0_11, null);
                    				

                    }
                    break;
                case 12 :
                    // InternalRsl.g:416:5: lv_value_0_12= 'Dec'
                    {
                    lv_value_0_12=(Token)match(input,26,FOLLOW_2); 

                    					newLeafNode(lv_value_0_12, grammarAccess.getMonthAccess().getValueDecKeyword_0_11());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getMonthRule());
                    					}
                    					setWithLastConsumed(current, "value", lv_value_0_12, null);
                    				

                    }
                    break;

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMonth"


    // $ANTLR start "entryRulePackageSystem"
    // InternalRsl.g:432:1: entryRulePackageSystem returns [EObject current=null] : iv_rulePackageSystem= rulePackageSystem EOF ;
    public final EObject entryRulePackageSystem() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePackageSystem = null;


        try {
            // InternalRsl.g:432:54: (iv_rulePackageSystem= rulePackageSystem EOF )
            // InternalRsl.g:433:2: iv_rulePackageSystem= rulePackageSystem EOF
            {
             newCompositeNode(grammarAccess.getPackageSystemRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePackageSystem=rulePackageSystem();

            state._fsp--;

             current =iv_rulePackageSystem; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePackageSystem"


    // $ANTLR start "rulePackageSystem"
    // InternalRsl.g:439:1: rulePackageSystem returns [EObject current=null] : (otherlv_0= 'package-system' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_imports_2_0= ruleImport ) )* ( (lv_system_3_0= ruleSystem ) ) ( (lv_entities_4_0= ruleDataEntity ) )* ( (lv_dataEntityViews_5_0= ruleDataEntityView ) )* ( (lv_actors_6_0= ruleActor ) )* ( (lv_requirements_7_0= ruleRequirement ) )* ( (lv_stateMachine_8_0= ruleStateMachine ) )* ( (lv_requirementRelations_9_0= ruleRequirementRelation ) )* ) ;
    public final EObject rulePackageSystem() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_imports_2_0 = null;

        EObject lv_system_3_0 = null;

        EObject lv_entities_4_0 = null;

        EObject lv_dataEntityViews_5_0 = null;

        EObject lv_actors_6_0 = null;

        EObject lv_requirements_7_0 = null;

        EObject lv_stateMachine_8_0 = null;

        EObject lv_requirementRelations_9_0 = null;



        	enterRule();

        try {
            // InternalRsl.g:445:2: ( (otherlv_0= 'package-system' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_imports_2_0= ruleImport ) )* ( (lv_system_3_0= ruleSystem ) ) ( (lv_entities_4_0= ruleDataEntity ) )* ( (lv_dataEntityViews_5_0= ruleDataEntityView ) )* ( (lv_actors_6_0= ruleActor ) )* ( (lv_requirements_7_0= ruleRequirement ) )* ( (lv_stateMachine_8_0= ruleStateMachine ) )* ( (lv_requirementRelations_9_0= ruleRequirementRelation ) )* ) )
            // InternalRsl.g:446:2: (otherlv_0= 'package-system' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_imports_2_0= ruleImport ) )* ( (lv_system_3_0= ruleSystem ) ) ( (lv_entities_4_0= ruleDataEntity ) )* ( (lv_dataEntityViews_5_0= ruleDataEntityView ) )* ( (lv_actors_6_0= ruleActor ) )* ( (lv_requirements_7_0= ruleRequirement ) )* ( (lv_stateMachine_8_0= ruleStateMachine ) )* ( (lv_requirementRelations_9_0= ruleRequirementRelation ) )* )
            {
            // InternalRsl.g:446:2: (otherlv_0= 'package-system' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_imports_2_0= ruleImport ) )* ( (lv_system_3_0= ruleSystem ) ) ( (lv_entities_4_0= ruleDataEntity ) )* ( (lv_dataEntityViews_5_0= ruleDataEntityView ) )* ( (lv_actors_6_0= ruleActor ) )* ( (lv_requirements_7_0= ruleRequirement ) )* ( (lv_stateMachine_8_0= ruleStateMachine ) )* ( (lv_requirementRelations_9_0= ruleRequirementRelation ) )* )
            // InternalRsl.g:447:3: otherlv_0= 'package-system' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_imports_2_0= ruleImport ) )* ( (lv_system_3_0= ruleSystem ) ) ( (lv_entities_4_0= ruleDataEntity ) )* ( (lv_dataEntityViews_5_0= ruleDataEntityView ) )* ( (lv_actors_6_0= ruleActor ) )* ( (lv_requirements_7_0= ruleRequirement ) )* ( (lv_stateMachine_8_0= ruleStateMachine ) )* ( (lv_requirementRelations_9_0= ruleRequirementRelation ) )*
            {
            otherlv_0=(Token)match(input,27,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getPackageSystemAccess().getPackageSystemKeyword_0());
            		
            // InternalRsl.g:451:3: ( (lv_name_1_0= ruleQualifiedName ) )
            // InternalRsl.g:452:4: (lv_name_1_0= ruleQualifiedName )
            {
            // InternalRsl.g:452:4: (lv_name_1_0= ruleQualifiedName )
            // InternalRsl.g:453:5: lv_name_1_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getPackageSystemAccess().getNameQualifiedNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_7);
            lv_name_1_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPackageSystemRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.rslingo.rsl.Rsl.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRsl.g:470:3: ( (lv_imports_2_0= ruleImport ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==14) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalRsl.g:471:4: (lv_imports_2_0= ruleImport )
            	    {
            	    // InternalRsl.g:471:4: (lv_imports_2_0= ruleImport )
            	    // InternalRsl.g:472:5: lv_imports_2_0= ruleImport
            	    {

            	    					newCompositeNode(grammarAccess.getPackageSystemAccess().getImportsImportParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_7);
            	    lv_imports_2_0=ruleImport();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getPackageSystemRule());
            	    					}
            	    					add(
            	    						current,
            	    						"imports",
            	    						lv_imports_2_0,
            	    						"org.rslingo.rsl.Rsl.Import");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            // InternalRsl.g:489:3: ( (lv_system_3_0= ruleSystem ) )
            // InternalRsl.g:490:4: (lv_system_3_0= ruleSystem )
            {
            // InternalRsl.g:490:4: (lv_system_3_0= ruleSystem )
            // InternalRsl.g:491:5: lv_system_3_0= ruleSystem
            {

            					newCompositeNode(grammarAccess.getPackageSystemAccess().getSystemSystemParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_8);
            lv_system_3_0=ruleSystem();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPackageSystemRule());
            					}
            					set(
            						current,
            						"system",
            						lv_system_3_0,
            						"org.rslingo.rsl.Rsl.System");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRsl.g:508:3: ( (lv_entities_4_0= ruleDataEntity ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==38) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalRsl.g:509:4: (lv_entities_4_0= ruleDataEntity )
            	    {
            	    // InternalRsl.g:509:4: (lv_entities_4_0= ruleDataEntity )
            	    // InternalRsl.g:510:5: lv_entities_4_0= ruleDataEntity
            	    {

            	    					newCompositeNode(grammarAccess.getPackageSystemAccess().getEntitiesDataEntityParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_8);
            	    lv_entities_4_0=ruleDataEntity();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getPackageSystemRule());
            	    					}
            	    					add(
            	    						current,
            	    						"entities",
            	    						lv_entities_4_0,
            	    						"org.rslingo.rsl.Rsl.DataEntity");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            // InternalRsl.g:527:3: ( (lv_dataEntityViews_5_0= ruleDataEntityView ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==55) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalRsl.g:528:4: (lv_dataEntityViews_5_0= ruleDataEntityView )
            	    {
            	    // InternalRsl.g:528:4: (lv_dataEntityViews_5_0= ruleDataEntityView )
            	    // InternalRsl.g:529:5: lv_dataEntityViews_5_0= ruleDataEntityView
            	    {

            	    					newCompositeNode(grammarAccess.getPackageSystemAccess().getDataEntityViewsDataEntityViewParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_9);
            	    lv_dataEntityViews_5_0=ruleDataEntityView();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getPackageSystemRule());
            	    					}
            	    					add(
            	    						current,
            	    						"dataEntityViews",
            	    						lv_dataEntityViews_5_0,
            	    						"org.rslingo.rsl.Rsl.DataEntityView");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            // InternalRsl.g:546:3: ( (lv_actors_6_0= ruleActor ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==59) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalRsl.g:547:4: (lv_actors_6_0= ruleActor )
            	    {
            	    // InternalRsl.g:547:4: (lv_actors_6_0= ruleActor )
            	    // InternalRsl.g:548:5: lv_actors_6_0= ruleActor
            	    {

            	    					newCompositeNode(grammarAccess.getPackageSystemAccess().getActorsActorParserRuleCall_6_0());
            	    				
            	    pushFollow(FOLLOW_10);
            	    lv_actors_6_0=ruleActor();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getPackageSystemRule());
            	    					}
            	    					add(
            	    						current,
            	    						"actors",
            	    						lv_actors_6_0,
            	    						"org.rslingo.rsl.Rsl.Actor");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            // InternalRsl.g:565:3: ( (lv_requirements_7_0= ruleRequirement ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==63) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalRsl.g:566:4: (lv_requirements_7_0= ruleRequirement )
            	    {
            	    // InternalRsl.g:566:4: (lv_requirements_7_0= ruleRequirement )
            	    // InternalRsl.g:567:5: lv_requirements_7_0= ruleRequirement
            	    {

            	    					newCompositeNode(grammarAccess.getPackageSystemAccess().getRequirementsRequirementParserRuleCall_7_0());
            	    				
            	    pushFollow(FOLLOW_11);
            	    lv_requirements_7_0=ruleRequirement();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getPackageSystemRule());
            	    					}
            	    					add(
            	    						current,
            	    						"requirements",
            	    						lv_requirements_7_0,
            	    						"org.rslingo.rsl.Rsl.Requirement");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            // InternalRsl.g:584:3: ( (lv_stateMachine_8_0= ruleStateMachine ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==81) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalRsl.g:585:4: (lv_stateMachine_8_0= ruleStateMachine )
            	    {
            	    // InternalRsl.g:585:4: (lv_stateMachine_8_0= ruleStateMachine )
            	    // InternalRsl.g:586:5: lv_stateMachine_8_0= ruleStateMachine
            	    {

            	    					newCompositeNode(grammarAccess.getPackageSystemAccess().getStateMachineStateMachineParserRuleCall_8_0());
            	    				
            	    pushFollow(FOLLOW_12);
            	    lv_stateMachine_8_0=ruleStateMachine();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getPackageSystemRule());
            	    					}
            	    					add(
            	    						current,
            	    						"stateMachine",
            	    						lv_stateMachine_8_0,
            	    						"org.rslingo.rsl.Rsl.StateMachine");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            // InternalRsl.g:603:3: ( (lv_requirementRelations_9_0= ruleRequirementRelation ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==60) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalRsl.g:604:4: (lv_requirementRelations_9_0= ruleRequirementRelation )
            	    {
            	    // InternalRsl.g:604:4: (lv_requirementRelations_9_0= ruleRequirementRelation )
            	    // InternalRsl.g:605:5: lv_requirementRelations_9_0= ruleRequirementRelation
            	    {

            	    					newCompositeNode(grammarAccess.getPackageSystemAccess().getRequirementRelationsRequirementRelationParserRuleCall_9_0());
            	    				
            	    pushFollow(FOLLOW_13);
            	    lv_requirementRelations_9_0=ruleRequirementRelation();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getPackageSystemRule());
            	    					}
            	    					add(
            	    						current,
            	    						"requirementRelations",
            	    						lv_requirementRelations_9_0,
            	    						"org.rslingo.rsl.Rsl.RequirementRelation");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePackageSystem"


    // $ANTLR start "entryRuleSystem"
    // InternalRsl.g:626:1: entryRuleSystem returns [EObject current=null] : iv_ruleSystem= ruleSystem EOF ;
    public final EObject entryRuleSystem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSystem = null;


        try {
            // InternalRsl.g:626:47: (iv_ruleSystem= ruleSystem EOF )
            // InternalRsl.g:627:2: iv_ruleSystem= ruleSystem EOF
            {
             newCompositeNode(grammarAccess.getSystemRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSystem=ruleSystem();

            state._fsp--;

             current =iv_ruleSystem; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSystem"


    // $ANTLR start "ruleSystem"
    // InternalRsl.g:633:1: ruleSystem returns [EObject current=null] : (otherlv_0= 'system' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleSystemType ) ) otherlv_4= '[' (otherlv_5= 'name' ( (lv_nameAlias_6_0= RULE_STRING ) ) ) otherlv_7= 'scope' ( (lv_scope_8_0= ruleSystemScope ) )? (otherlv_9= 'subSystems' ( (lv_subSystems_10_0= ruleRefSystem ) ) )? (otherlv_11= 'reusableSystems' ( (lv_reusableSystems_12_0= ruleRefSystem ) ) )? (otherlv_13= 'description' ( (lv_description_14_0= RULE_STRING ) ) )? otherlv_15= ']' ) ;
    public final EObject ruleSystem() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token lv_nameAlias_6_0=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token lv_description_14_0=null;
        Token otherlv_15=null;
        Enumerator lv_type_3_0 = null;

        Enumerator lv_scope_8_0 = null;

        EObject lv_subSystems_10_0 = null;

        EObject lv_reusableSystems_12_0 = null;



        	enterRule();

        try {
            // InternalRsl.g:639:2: ( (otherlv_0= 'system' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleSystemType ) ) otherlv_4= '[' (otherlv_5= 'name' ( (lv_nameAlias_6_0= RULE_STRING ) ) ) otherlv_7= 'scope' ( (lv_scope_8_0= ruleSystemScope ) )? (otherlv_9= 'subSystems' ( (lv_subSystems_10_0= ruleRefSystem ) ) )? (otherlv_11= 'reusableSystems' ( (lv_reusableSystems_12_0= ruleRefSystem ) ) )? (otherlv_13= 'description' ( (lv_description_14_0= RULE_STRING ) ) )? otherlv_15= ']' ) )
            // InternalRsl.g:640:2: (otherlv_0= 'system' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleSystemType ) ) otherlv_4= '[' (otherlv_5= 'name' ( (lv_nameAlias_6_0= RULE_STRING ) ) ) otherlv_7= 'scope' ( (lv_scope_8_0= ruleSystemScope ) )? (otherlv_9= 'subSystems' ( (lv_subSystems_10_0= ruleRefSystem ) ) )? (otherlv_11= 'reusableSystems' ( (lv_reusableSystems_12_0= ruleRefSystem ) ) )? (otherlv_13= 'description' ( (lv_description_14_0= RULE_STRING ) ) )? otherlv_15= ']' )
            {
            // InternalRsl.g:640:2: (otherlv_0= 'system' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleSystemType ) ) otherlv_4= '[' (otherlv_5= 'name' ( (lv_nameAlias_6_0= RULE_STRING ) ) ) otherlv_7= 'scope' ( (lv_scope_8_0= ruleSystemScope ) )? (otherlv_9= 'subSystems' ( (lv_subSystems_10_0= ruleRefSystem ) ) )? (otherlv_11= 'reusableSystems' ( (lv_reusableSystems_12_0= ruleRefSystem ) ) )? (otherlv_13= 'description' ( (lv_description_14_0= RULE_STRING ) ) )? otherlv_15= ']' )
            // InternalRsl.g:641:3: otherlv_0= 'system' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleSystemType ) ) otherlv_4= '[' (otherlv_5= 'name' ( (lv_nameAlias_6_0= RULE_STRING ) ) ) otherlv_7= 'scope' ( (lv_scope_8_0= ruleSystemScope ) )? (otherlv_9= 'subSystems' ( (lv_subSystems_10_0= ruleRefSystem ) ) )? (otherlv_11= 'reusableSystems' ( (lv_reusableSystems_12_0= ruleRefSystem ) ) )? (otherlv_13= 'description' ( (lv_description_14_0= RULE_STRING ) ) )? otherlv_15= ']'
            {
            otherlv_0=(Token)match(input,28,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getSystemAccess().getSystemKeyword_0());
            		
            // InternalRsl.g:645:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalRsl.g:646:4: (lv_name_1_0= RULE_ID )
            {
            // InternalRsl.g:646:4: (lv_name_1_0= RULE_ID )
            // InternalRsl.g:647:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_14); 

            					newLeafNode(lv_name_1_0, grammarAccess.getSystemAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSystemRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,29,FOLLOW_15); 

            			newLeafNode(otherlv_2, grammarAccess.getSystemAccess().getColonKeyword_2());
            		
            // InternalRsl.g:667:3: ( (lv_type_3_0= ruleSystemType ) )
            // InternalRsl.g:668:4: (lv_type_3_0= ruleSystemType )
            {
            // InternalRsl.g:668:4: (lv_type_3_0= ruleSystemType )
            // InternalRsl.g:669:5: lv_type_3_0= ruleSystemType
            {

            					newCompositeNode(grammarAccess.getSystemAccess().getTypeSystemTypeEnumRuleCall_3_0());
            				
            pushFollow(FOLLOW_16);
            lv_type_3_0=ruleSystemType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSystemRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_3_0,
            						"org.rslingo.rsl.Rsl.SystemType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,30,FOLLOW_17); 

            			newLeafNode(otherlv_4, grammarAccess.getSystemAccess().getLeftSquareBracketKeyword_4());
            		
            // InternalRsl.g:690:3: (otherlv_5= 'name' ( (lv_nameAlias_6_0= RULE_STRING ) ) )
            // InternalRsl.g:691:4: otherlv_5= 'name' ( (lv_nameAlias_6_0= RULE_STRING ) )
            {
            otherlv_5=(Token)match(input,31,FOLLOW_18); 

            				newLeafNode(otherlv_5, grammarAccess.getSystemAccess().getNameKeyword_5_0());
            			
            // InternalRsl.g:695:4: ( (lv_nameAlias_6_0= RULE_STRING ) )
            // InternalRsl.g:696:5: (lv_nameAlias_6_0= RULE_STRING )
            {
            // InternalRsl.g:696:5: (lv_nameAlias_6_0= RULE_STRING )
            // InternalRsl.g:697:6: lv_nameAlias_6_0= RULE_STRING
            {
            lv_nameAlias_6_0=(Token)match(input,RULE_STRING,FOLLOW_19); 

            						newLeafNode(lv_nameAlias_6_0, grammarAccess.getSystemAccess().getNameAliasSTRINGTerminalRuleCall_5_1_0());
            					

            						if (current==null) {
            							current = createModelElement(grammarAccess.getSystemRule());
            						}
            						setWithLastConsumed(
            							current,
            							"nameAlias",
            							lv_nameAlias_6_0,
            							"org.eclipse.xtext.common.Terminals.STRING");
            					

            }


            }


            }

            otherlv_7=(Token)match(input,32,FOLLOW_20); 

            			newLeafNode(otherlv_7, grammarAccess.getSystemAccess().getScopeKeyword_6());
            		
            // InternalRsl.g:718:3: ( (lv_scope_8_0= ruleSystemScope ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( ((LA13_0>=94 && LA13_0<=95)) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalRsl.g:719:4: (lv_scope_8_0= ruleSystemScope )
                    {
                    // InternalRsl.g:719:4: (lv_scope_8_0= ruleSystemScope )
                    // InternalRsl.g:720:5: lv_scope_8_0= ruleSystemScope
                    {

                    					newCompositeNode(grammarAccess.getSystemAccess().getScopeSystemScopeEnumRuleCall_7_0());
                    				
                    pushFollow(FOLLOW_21);
                    lv_scope_8_0=ruleSystemScope();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getSystemRule());
                    					}
                    					set(
                    						current,
                    						"scope",
                    						lv_scope_8_0,
                    						"org.rslingo.rsl.Rsl.SystemScope");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalRsl.g:737:3: (otherlv_9= 'subSystems' ( (lv_subSystems_10_0= ruleRefSystem ) ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==33) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalRsl.g:738:4: otherlv_9= 'subSystems' ( (lv_subSystems_10_0= ruleRefSystem ) )
                    {
                    otherlv_9=(Token)match(input,33,FOLLOW_5); 

                    				newLeafNode(otherlv_9, grammarAccess.getSystemAccess().getSubSystemsKeyword_8_0());
                    			
                    // InternalRsl.g:742:4: ( (lv_subSystems_10_0= ruleRefSystem ) )
                    // InternalRsl.g:743:5: (lv_subSystems_10_0= ruleRefSystem )
                    {
                    // InternalRsl.g:743:5: (lv_subSystems_10_0= ruleRefSystem )
                    // InternalRsl.g:744:6: lv_subSystems_10_0= ruleRefSystem
                    {

                    						newCompositeNode(grammarAccess.getSystemAccess().getSubSystemsRefSystemParserRuleCall_8_1_0());
                    					
                    pushFollow(FOLLOW_22);
                    lv_subSystems_10_0=ruleRefSystem();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getSystemRule());
                    						}
                    						set(
                    							current,
                    							"subSystems",
                    							lv_subSystems_10_0,
                    							"org.rslingo.rsl.Rsl.RefSystem");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalRsl.g:762:3: (otherlv_11= 'reusableSystems' ( (lv_reusableSystems_12_0= ruleRefSystem ) ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==34) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalRsl.g:763:4: otherlv_11= 'reusableSystems' ( (lv_reusableSystems_12_0= ruleRefSystem ) )
                    {
                    otherlv_11=(Token)match(input,34,FOLLOW_5); 

                    				newLeafNode(otherlv_11, grammarAccess.getSystemAccess().getReusableSystemsKeyword_9_0());
                    			
                    // InternalRsl.g:767:4: ( (lv_reusableSystems_12_0= ruleRefSystem ) )
                    // InternalRsl.g:768:5: (lv_reusableSystems_12_0= ruleRefSystem )
                    {
                    // InternalRsl.g:768:5: (lv_reusableSystems_12_0= ruleRefSystem )
                    // InternalRsl.g:769:6: lv_reusableSystems_12_0= ruleRefSystem
                    {

                    						newCompositeNode(grammarAccess.getSystemAccess().getReusableSystemsRefSystemParserRuleCall_9_1_0());
                    					
                    pushFollow(FOLLOW_23);
                    lv_reusableSystems_12_0=ruleRefSystem();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getSystemRule());
                    						}
                    						set(
                    							current,
                    							"reusableSystems",
                    							lv_reusableSystems_12_0,
                    							"org.rslingo.rsl.Rsl.RefSystem");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalRsl.g:787:3: (otherlv_13= 'description' ( (lv_description_14_0= RULE_STRING ) ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==35) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalRsl.g:788:4: otherlv_13= 'description' ( (lv_description_14_0= RULE_STRING ) )
                    {
                    otherlv_13=(Token)match(input,35,FOLLOW_18); 

                    				newLeafNode(otherlv_13, grammarAccess.getSystemAccess().getDescriptionKeyword_10_0());
                    			
                    // InternalRsl.g:792:4: ( (lv_description_14_0= RULE_STRING ) )
                    // InternalRsl.g:793:5: (lv_description_14_0= RULE_STRING )
                    {
                    // InternalRsl.g:793:5: (lv_description_14_0= RULE_STRING )
                    // InternalRsl.g:794:6: lv_description_14_0= RULE_STRING
                    {
                    lv_description_14_0=(Token)match(input,RULE_STRING,FOLLOW_24); 

                    						newLeafNode(lv_description_14_0, grammarAccess.getSystemAccess().getDescriptionSTRINGTerminalRuleCall_10_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getSystemRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"description",
                    							lv_description_14_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_15=(Token)match(input,36,FOLLOW_2); 

            			newLeafNode(otherlv_15, grammarAccess.getSystemAccess().getRightSquareBracketKeyword_11());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSystem"


    // $ANTLR start "entryRuleRefSystem"
    // InternalRsl.g:819:1: entryRuleRefSystem returns [EObject current=null] : iv_ruleRefSystem= ruleRefSystem EOF ;
    public final EObject entryRuleRefSystem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefSystem = null;


        try {
            // InternalRsl.g:819:50: (iv_ruleRefSystem= ruleRefSystem EOF )
            // InternalRsl.g:820:2: iv_ruleRefSystem= ruleRefSystem EOF
            {
             newCompositeNode(grammarAccess.getRefSystemRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRefSystem=ruleRefSystem();

            state._fsp--;

             current =iv_ruleRefSystem; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRefSystem"


    // $ANTLR start "ruleRefSystem"
    // InternalRsl.g:826:1: ruleRefSystem returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= ',' ( (otherlv_2= RULE_ID ) ) )* ) ;
    public final EObject ruleRefSystem() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalRsl.g:832:2: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= ',' ( (otherlv_2= RULE_ID ) ) )* ) )
            // InternalRsl.g:833:2: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= ',' ( (otherlv_2= RULE_ID ) ) )* )
            {
            // InternalRsl.g:833:2: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= ',' ( (otherlv_2= RULE_ID ) ) )* )
            // InternalRsl.g:834:3: ( (otherlv_0= RULE_ID ) ) (otherlv_1= ',' ( (otherlv_2= RULE_ID ) ) )*
            {
            // InternalRsl.g:834:3: ( (otherlv_0= RULE_ID ) )
            // InternalRsl.g:835:4: (otherlv_0= RULE_ID )
            {
            // InternalRsl.g:835:4: (otherlv_0= RULE_ID )
            // InternalRsl.g:836:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRefSystemRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_25); 

            					newLeafNode(otherlv_0, grammarAccess.getRefSystemAccess().getRefsSystemCrossReference_0_0());
            				

            }


            }

            // InternalRsl.g:847:3: (otherlv_1= ',' ( (otherlv_2= RULE_ID ) ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==37) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalRsl.g:848:4: otherlv_1= ',' ( (otherlv_2= RULE_ID ) )
            	    {
            	    otherlv_1=(Token)match(input,37,FOLLOW_5); 

            	    				newLeafNode(otherlv_1, grammarAccess.getRefSystemAccess().getCommaKeyword_1_0());
            	    			
            	    // InternalRsl.g:852:4: ( (otherlv_2= RULE_ID ) )
            	    // InternalRsl.g:853:5: (otherlv_2= RULE_ID )
            	    {
            	    // InternalRsl.g:853:5: (otherlv_2= RULE_ID )
            	    // InternalRsl.g:854:6: otherlv_2= RULE_ID
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getRefSystemRule());
            	    						}
            	    					
            	    otherlv_2=(Token)match(input,RULE_ID,FOLLOW_25); 

            	    						newLeafNode(otherlv_2, grammarAccess.getRefSystemAccess().getRefsSystemCrossReference_1_1_0());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRefSystem"


    // $ANTLR start "entryRuleDataEntity"
    // InternalRsl.g:870:1: entryRuleDataEntity returns [EObject current=null] : iv_ruleDataEntity= ruleDataEntity EOF ;
    public final EObject entryRuleDataEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataEntity = null;


        try {
            // InternalRsl.g:870:51: (iv_ruleDataEntity= ruleDataEntity EOF )
            // InternalRsl.g:871:2: iv_ruleDataEntity= ruleDataEntity EOF
            {
             newCompositeNode(grammarAccess.getDataEntityRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDataEntity=ruleDataEntity();

            state._fsp--;

             current =iv_ruleDataEntity; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDataEntity"


    // $ANTLR start "ruleDataEntity"
    // InternalRsl.g:877:1: ruleDataEntity returns [EObject current=null] : (otherlv_0= 'dataEntity' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleDataEntityType ) ) (otherlv_4= ':' ( (lv_subType_5_0= ruleDataEntitySubType ) ) )? otherlv_6= '[' (otherlv_7= 'name' ( (lv_nameAlias_8_0= RULE_STRING ) ) ) (otherlv_9= 'isA' ( (otherlv_10= RULE_ID ) ) )? ( (lv_attributes_11_0= ruleAttribute ) )+ ( (lv_primaryKey_12_0= rulePrimaryKey ) )? ( (lv_foreignKeys_13_0= ruleForeignKey ) )* ( (lv_checks_14_0= ruleCheck ) )* (otherlv_15= 'description' ( (lv_description_16_0= RULE_STRING ) ) )? otherlv_17= ']' ) ;
    public final EObject ruleDataEntity() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token lv_nameAlias_8_0=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_15=null;
        Token lv_description_16_0=null;
        Token otherlv_17=null;
        Enumerator lv_type_3_0 = null;

        Enumerator lv_subType_5_0 = null;

        EObject lv_attributes_11_0 = null;

        EObject lv_primaryKey_12_0 = null;

        EObject lv_foreignKeys_13_0 = null;

        EObject lv_checks_14_0 = null;



        	enterRule();

        try {
            // InternalRsl.g:883:2: ( (otherlv_0= 'dataEntity' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleDataEntityType ) ) (otherlv_4= ':' ( (lv_subType_5_0= ruleDataEntitySubType ) ) )? otherlv_6= '[' (otherlv_7= 'name' ( (lv_nameAlias_8_0= RULE_STRING ) ) ) (otherlv_9= 'isA' ( (otherlv_10= RULE_ID ) ) )? ( (lv_attributes_11_0= ruleAttribute ) )+ ( (lv_primaryKey_12_0= rulePrimaryKey ) )? ( (lv_foreignKeys_13_0= ruleForeignKey ) )* ( (lv_checks_14_0= ruleCheck ) )* (otherlv_15= 'description' ( (lv_description_16_0= RULE_STRING ) ) )? otherlv_17= ']' ) )
            // InternalRsl.g:884:2: (otherlv_0= 'dataEntity' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleDataEntityType ) ) (otherlv_4= ':' ( (lv_subType_5_0= ruleDataEntitySubType ) ) )? otherlv_6= '[' (otherlv_7= 'name' ( (lv_nameAlias_8_0= RULE_STRING ) ) ) (otherlv_9= 'isA' ( (otherlv_10= RULE_ID ) ) )? ( (lv_attributes_11_0= ruleAttribute ) )+ ( (lv_primaryKey_12_0= rulePrimaryKey ) )? ( (lv_foreignKeys_13_0= ruleForeignKey ) )* ( (lv_checks_14_0= ruleCheck ) )* (otherlv_15= 'description' ( (lv_description_16_0= RULE_STRING ) ) )? otherlv_17= ']' )
            {
            // InternalRsl.g:884:2: (otherlv_0= 'dataEntity' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleDataEntityType ) ) (otherlv_4= ':' ( (lv_subType_5_0= ruleDataEntitySubType ) ) )? otherlv_6= '[' (otherlv_7= 'name' ( (lv_nameAlias_8_0= RULE_STRING ) ) ) (otherlv_9= 'isA' ( (otherlv_10= RULE_ID ) ) )? ( (lv_attributes_11_0= ruleAttribute ) )+ ( (lv_primaryKey_12_0= rulePrimaryKey ) )? ( (lv_foreignKeys_13_0= ruleForeignKey ) )* ( (lv_checks_14_0= ruleCheck ) )* (otherlv_15= 'description' ( (lv_description_16_0= RULE_STRING ) ) )? otherlv_17= ']' )
            // InternalRsl.g:885:3: otherlv_0= 'dataEntity' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleDataEntityType ) ) (otherlv_4= ':' ( (lv_subType_5_0= ruleDataEntitySubType ) ) )? otherlv_6= '[' (otherlv_7= 'name' ( (lv_nameAlias_8_0= RULE_STRING ) ) ) (otherlv_9= 'isA' ( (otherlv_10= RULE_ID ) ) )? ( (lv_attributes_11_0= ruleAttribute ) )+ ( (lv_primaryKey_12_0= rulePrimaryKey ) )? ( (lv_foreignKeys_13_0= ruleForeignKey ) )* ( (lv_checks_14_0= ruleCheck ) )* (otherlv_15= 'description' ( (lv_description_16_0= RULE_STRING ) ) )? otherlv_17= ']'
            {
            otherlv_0=(Token)match(input,38,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getDataEntityAccess().getDataEntityKeyword_0());
            		
            // InternalRsl.g:889:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalRsl.g:890:4: (lv_name_1_0= RULE_ID )
            {
            // InternalRsl.g:890:4: (lv_name_1_0= RULE_ID )
            // InternalRsl.g:891:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_14); 

            					newLeafNode(lv_name_1_0, grammarAccess.getDataEntityAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDataEntityRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,29,FOLLOW_26); 

            			newLeafNode(otherlv_2, grammarAccess.getDataEntityAccess().getColonKeyword_2());
            		
            // InternalRsl.g:911:3: ( (lv_type_3_0= ruleDataEntityType ) )
            // InternalRsl.g:912:4: (lv_type_3_0= ruleDataEntityType )
            {
            // InternalRsl.g:912:4: (lv_type_3_0= ruleDataEntityType )
            // InternalRsl.g:913:5: lv_type_3_0= ruleDataEntityType
            {

            					newCompositeNode(grammarAccess.getDataEntityAccess().getTypeDataEntityTypeEnumRuleCall_3_0());
            				
            pushFollow(FOLLOW_27);
            lv_type_3_0=ruleDataEntityType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDataEntityRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_3_0,
            						"org.rslingo.rsl.Rsl.DataEntityType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRsl.g:930:3: (otherlv_4= ':' ( (lv_subType_5_0= ruleDataEntitySubType ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==29) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalRsl.g:931:4: otherlv_4= ':' ( (lv_subType_5_0= ruleDataEntitySubType ) )
                    {
                    otherlv_4=(Token)match(input,29,FOLLOW_28); 

                    				newLeafNode(otherlv_4, grammarAccess.getDataEntityAccess().getColonKeyword_4_0());
                    			
                    // InternalRsl.g:935:4: ( (lv_subType_5_0= ruleDataEntitySubType ) )
                    // InternalRsl.g:936:5: (lv_subType_5_0= ruleDataEntitySubType )
                    {
                    // InternalRsl.g:936:5: (lv_subType_5_0= ruleDataEntitySubType )
                    // InternalRsl.g:937:6: lv_subType_5_0= ruleDataEntitySubType
                    {

                    						newCompositeNode(grammarAccess.getDataEntityAccess().getSubTypeDataEntitySubTypeEnumRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_16);
                    lv_subType_5_0=ruleDataEntitySubType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDataEntityRule());
                    						}
                    						set(
                    							current,
                    							"subType",
                    							lv_subType_5_0,
                    							"org.rslingo.rsl.Rsl.DataEntitySubType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,30,FOLLOW_17); 

            			newLeafNode(otherlv_6, grammarAccess.getDataEntityAccess().getLeftSquareBracketKeyword_5());
            		
            // InternalRsl.g:959:3: (otherlv_7= 'name' ( (lv_nameAlias_8_0= RULE_STRING ) ) )
            // InternalRsl.g:960:4: otherlv_7= 'name' ( (lv_nameAlias_8_0= RULE_STRING ) )
            {
            otherlv_7=(Token)match(input,31,FOLLOW_18); 

            				newLeafNode(otherlv_7, grammarAccess.getDataEntityAccess().getNameKeyword_6_0());
            			
            // InternalRsl.g:964:4: ( (lv_nameAlias_8_0= RULE_STRING ) )
            // InternalRsl.g:965:5: (lv_nameAlias_8_0= RULE_STRING )
            {
            // InternalRsl.g:965:5: (lv_nameAlias_8_0= RULE_STRING )
            // InternalRsl.g:966:6: lv_nameAlias_8_0= RULE_STRING
            {
            lv_nameAlias_8_0=(Token)match(input,RULE_STRING,FOLLOW_29); 

            						newLeafNode(lv_nameAlias_8_0, grammarAccess.getDataEntityAccess().getNameAliasSTRINGTerminalRuleCall_6_1_0());
            					

            						if (current==null) {
            							current = createModelElement(grammarAccess.getDataEntityRule());
            						}
            						setWithLastConsumed(
            							current,
            							"nameAlias",
            							lv_nameAlias_8_0,
            							"org.eclipse.xtext.common.Terminals.STRING");
            					

            }


            }


            }

            // InternalRsl.g:983:3: (otherlv_9= 'isA' ( (otherlv_10= RULE_ID ) ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==39) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalRsl.g:984:4: otherlv_9= 'isA' ( (otherlv_10= RULE_ID ) )
                    {
                    otherlv_9=(Token)match(input,39,FOLLOW_5); 

                    				newLeafNode(otherlv_9, grammarAccess.getDataEntityAccess().getIsAKeyword_7_0());
                    			
                    // InternalRsl.g:988:4: ( (otherlv_10= RULE_ID ) )
                    // InternalRsl.g:989:5: (otherlv_10= RULE_ID )
                    {
                    // InternalRsl.g:989:5: (otherlv_10= RULE_ID )
                    // InternalRsl.g:990:6: otherlv_10= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDataEntityRule());
                    						}
                    					
                    otherlv_10=(Token)match(input,RULE_ID,FOLLOW_29); 

                    						newLeafNode(otherlv_10, grammarAccess.getDataEntityAccess().getSuperDataEntityCrossReference_7_1_0());
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalRsl.g:1002:3: ( (lv_attributes_11_0= ruleAttribute ) )+
            int cnt20=0;
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==40) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalRsl.g:1003:4: (lv_attributes_11_0= ruleAttribute )
            	    {
            	    // InternalRsl.g:1003:4: (lv_attributes_11_0= ruleAttribute )
            	    // InternalRsl.g:1004:5: lv_attributes_11_0= ruleAttribute
            	    {

            	    					newCompositeNode(grammarAccess.getDataEntityAccess().getAttributesAttributeParserRuleCall_8_0());
            	    				
            	    pushFollow(FOLLOW_30);
            	    lv_attributes_11_0=ruleAttribute();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getDataEntityRule());
            	    					}
            	    					add(
            	    						current,
            	    						"attributes",
            	    						lv_attributes_11_0,
            	    						"org.rslingo.rsl.Rsl.Attribute");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt20 >= 1 ) break loop20;
                        EarlyExitException eee =
                            new EarlyExitException(20, input);
                        throw eee;
                }
                cnt20++;
            } while (true);

            // InternalRsl.g:1021:3: ( (lv_primaryKey_12_0= rulePrimaryKey ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==52) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalRsl.g:1022:4: (lv_primaryKey_12_0= rulePrimaryKey )
                    {
                    // InternalRsl.g:1022:4: (lv_primaryKey_12_0= rulePrimaryKey )
                    // InternalRsl.g:1023:5: lv_primaryKey_12_0= rulePrimaryKey
                    {

                    					newCompositeNode(grammarAccess.getDataEntityAccess().getPrimaryKeyPrimaryKeyParserRuleCall_9_0());
                    				
                    pushFollow(FOLLOW_31);
                    lv_primaryKey_12_0=rulePrimaryKey();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getDataEntityRule());
                    					}
                    					set(
                    						current,
                    						"primaryKey",
                    						lv_primaryKey_12_0,
                    						"org.rslingo.rsl.Rsl.PrimaryKey");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalRsl.g:1040:3: ( (lv_foreignKeys_13_0= ruleForeignKey ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==53) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalRsl.g:1041:4: (lv_foreignKeys_13_0= ruleForeignKey )
            	    {
            	    // InternalRsl.g:1041:4: (lv_foreignKeys_13_0= ruleForeignKey )
            	    // InternalRsl.g:1042:5: lv_foreignKeys_13_0= ruleForeignKey
            	    {

            	    					newCompositeNode(grammarAccess.getDataEntityAccess().getForeignKeysForeignKeyParserRuleCall_10_0());
            	    				
            	    pushFollow(FOLLOW_31);
            	    lv_foreignKeys_13_0=ruleForeignKey();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getDataEntityRule());
            	    					}
            	    					add(
            	    						current,
            	    						"foreignKeys",
            	    						lv_foreignKeys_13_0,
            	    						"org.rslingo.rsl.Rsl.ForeignKey");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

            // InternalRsl.g:1059:3: ( (lv_checks_14_0= ruleCheck ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==54) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalRsl.g:1060:4: (lv_checks_14_0= ruleCheck )
            	    {
            	    // InternalRsl.g:1060:4: (lv_checks_14_0= ruleCheck )
            	    // InternalRsl.g:1061:5: lv_checks_14_0= ruleCheck
            	    {

            	    					newCompositeNode(grammarAccess.getDataEntityAccess().getChecksCheckParserRuleCall_11_0());
            	    				
            	    pushFollow(FOLLOW_32);
            	    lv_checks_14_0=ruleCheck();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getDataEntityRule());
            	    					}
            	    					add(
            	    						current,
            	    						"checks",
            	    						lv_checks_14_0,
            	    						"org.rslingo.rsl.Rsl.Check");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            // InternalRsl.g:1078:3: (otherlv_15= 'description' ( (lv_description_16_0= RULE_STRING ) ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==35) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalRsl.g:1079:4: otherlv_15= 'description' ( (lv_description_16_0= RULE_STRING ) )
                    {
                    otherlv_15=(Token)match(input,35,FOLLOW_18); 

                    				newLeafNode(otherlv_15, grammarAccess.getDataEntityAccess().getDescriptionKeyword_12_0());
                    			
                    // InternalRsl.g:1083:4: ( (lv_description_16_0= RULE_STRING ) )
                    // InternalRsl.g:1084:5: (lv_description_16_0= RULE_STRING )
                    {
                    // InternalRsl.g:1084:5: (lv_description_16_0= RULE_STRING )
                    // InternalRsl.g:1085:6: lv_description_16_0= RULE_STRING
                    {
                    lv_description_16_0=(Token)match(input,RULE_STRING,FOLLOW_24); 

                    						newLeafNode(lv_description_16_0, grammarAccess.getDataEntityAccess().getDescriptionSTRINGTerminalRuleCall_12_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDataEntityRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"description",
                    							lv_description_16_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_17=(Token)match(input,36,FOLLOW_2); 

            			newLeafNode(otherlv_17, grammarAccess.getDataEntityAccess().getRightSquareBracketKeyword_13());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDataEntity"


    // $ANTLR start "entryRuleAttribute"
    // InternalRsl.g:1110:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // InternalRsl.g:1110:50: (iv_ruleAttribute= ruleAttribute EOF )
            // InternalRsl.g:1111:2: iv_ruleAttribute= ruleAttribute EOF
            {
             newCompositeNode(grammarAccess.getAttributeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAttribute=ruleAttribute();

            state._fsp--;

             current =iv_ruleAttribute; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAttribute"


    // $ANTLR start "ruleAttribute"
    // InternalRsl.g:1117:1: ruleAttribute returns [EObject current=null] : (otherlv_0= 'attribute' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleAttributeType ) ) (otherlv_4= '(' ( (lv_size_5_0= ruleDoubleOrInt ) ) otherlv_6= ')' )? otherlv_7= '[' (otherlv_8= 'name' ( (lv_nameAlias_9_0= RULE_STRING ) ) ) (otherlv_10= 'multiplicity' ( (lv_multiplicity_11_0= ruleMultiplicity ) ) )? (otherlv_12= 'defaultValue' ( (lv_defaultValue_13_0= RULE_STRING ) ) )? (otherlv_14= 'values' ( (lv_values_15_0= RULE_STRING ) ) )? ( (lv_notNull_16_0= 'NotNull' ) )? ( (lv_unique_17_0= 'Unique' ) )? (otherlv_18= 'description' ( (lv_description_19_0= RULE_STRING ) ) )? otherlv_20= ']' ) ;
    public final EObject ruleAttribute() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token lv_nameAlias_9_0=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token lv_defaultValue_13_0=null;
        Token otherlv_14=null;
        Token lv_values_15_0=null;
        Token lv_notNull_16_0=null;
        Token lv_unique_17_0=null;
        Token otherlv_18=null;
        Token lv_description_19_0=null;
        Token otherlv_20=null;
        Enumerator lv_type_3_0 = null;

        AntlrDatatypeRuleToken lv_size_5_0 = null;

        EObject lv_multiplicity_11_0 = null;



        	enterRule();

        try {
            // InternalRsl.g:1123:2: ( (otherlv_0= 'attribute' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleAttributeType ) ) (otherlv_4= '(' ( (lv_size_5_0= ruleDoubleOrInt ) ) otherlv_6= ')' )? otherlv_7= '[' (otherlv_8= 'name' ( (lv_nameAlias_9_0= RULE_STRING ) ) ) (otherlv_10= 'multiplicity' ( (lv_multiplicity_11_0= ruleMultiplicity ) ) )? (otherlv_12= 'defaultValue' ( (lv_defaultValue_13_0= RULE_STRING ) ) )? (otherlv_14= 'values' ( (lv_values_15_0= RULE_STRING ) ) )? ( (lv_notNull_16_0= 'NotNull' ) )? ( (lv_unique_17_0= 'Unique' ) )? (otherlv_18= 'description' ( (lv_description_19_0= RULE_STRING ) ) )? otherlv_20= ']' ) )
            // InternalRsl.g:1124:2: (otherlv_0= 'attribute' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleAttributeType ) ) (otherlv_4= '(' ( (lv_size_5_0= ruleDoubleOrInt ) ) otherlv_6= ')' )? otherlv_7= '[' (otherlv_8= 'name' ( (lv_nameAlias_9_0= RULE_STRING ) ) ) (otherlv_10= 'multiplicity' ( (lv_multiplicity_11_0= ruleMultiplicity ) ) )? (otherlv_12= 'defaultValue' ( (lv_defaultValue_13_0= RULE_STRING ) ) )? (otherlv_14= 'values' ( (lv_values_15_0= RULE_STRING ) ) )? ( (lv_notNull_16_0= 'NotNull' ) )? ( (lv_unique_17_0= 'Unique' ) )? (otherlv_18= 'description' ( (lv_description_19_0= RULE_STRING ) ) )? otherlv_20= ']' )
            {
            // InternalRsl.g:1124:2: (otherlv_0= 'attribute' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleAttributeType ) ) (otherlv_4= '(' ( (lv_size_5_0= ruleDoubleOrInt ) ) otherlv_6= ')' )? otherlv_7= '[' (otherlv_8= 'name' ( (lv_nameAlias_9_0= RULE_STRING ) ) ) (otherlv_10= 'multiplicity' ( (lv_multiplicity_11_0= ruleMultiplicity ) ) )? (otherlv_12= 'defaultValue' ( (lv_defaultValue_13_0= RULE_STRING ) ) )? (otherlv_14= 'values' ( (lv_values_15_0= RULE_STRING ) ) )? ( (lv_notNull_16_0= 'NotNull' ) )? ( (lv_unique_17_0= 'Unique' ) )? (otherlv_18= 'description' ( (lv_description_19_0= RULE_STRING ) ) )? otherlv_20= ']' )
            // InternalRsl.g:1125:3: otherlv_0= 'attribute' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleAttributeType ) ) (otherlv_4= '(' ( (lv_size_5_0= ruleDoubleOrInt ) ) otherlv_6= ')' )? otherlv_7= '[' (otherlv_8= 'name' ( (lv_nameAlias_9_0= RULE_STRING ) ) ) (otherlv_10= 'multiplicity' ( (lv_multiplicity_11_0= ruleMultiplicity ) ) )? (otherlv_12= 'defaultValue' ( (lv_defaultValue_13_0= RULE_STRING ) ) )? (otherlv_14= 'values' ( (lv_values_15_0= RULE_STRING ) ) )? ( (lv_notNull_16_0= 'NotNull' ) )? ( (lv_unique_17_0= 'Unique' ) )? (otherlv_18= 'description' ( (lv_description_19_0= RULE_STRING ) ) )? otherlv_20= ']'
            {
            otherlv_0=(Token)match(input,40,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getAttributeAccess().getAttributeKeyword_0());
            		
            // InternalRsl.g:1129:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalRsl.g:1130:4: (lv_name_1_0= RULE_ID )
            {
            // InternalRsl.g:1130:4: (lv_name_1_0= RULE_ID )
            // InternalRsl.g:1131:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_14); 

            					newLeafNode(lv_name_1_0, grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAttributeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,29,FOLLOW_33); 

            			newLeafNode(otherlv_2, grammarAccess.getAttributeAccess().getColonKeyword_2());
            		
            // InternalRsl.g:1151:3: ( (lv_type_3_0= ruleAttributeType ) )
            // InternalRsl.g:1152:4: (lv_type_3_0= ruleAttributeType )
            {
            // InternalRsl.g:1152:4: (lv_type_3_0= ruleAttributeType )
            // InternalRsl.g:1153:5: lv_type_3_0= ruleAttributeType
            {

            					newCompositeNode(grammarAccess.getAttributeAccess().getTypeAttributeTypeEnumRuleCall_3_0());
            				
            pushFollow(FOLLOW_34);
            lv_type_3_0=ruleAttributeType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAttributeRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_3_0,
            						"org.rslingo.rsl.Rsl.AttributeType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRsl.g:1170:3: (otherlv_4= '(' ( (lv_size_5_0= ruleDoubleOrInt ) ) otherlv_6= ')' )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==41) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalRsl.g:1171:4: otherlv_4= '(' ( (lv_size_5_0= ruleDoubleOrInt ) ) otherlv_6= ')'
                    {
                    otherlv_4=(Token)match(input,41,FOLLOW_35); 

                    				newLeafNode(otherlv_4, grammarAccess.getAttributeAccess().getLeftParenthesisKeyword_4_0());
                    			
                    // InternalRsl.g:1175:4: ( (lv_size_5_0= ruleDoubleOrInt ) )
                    // InternalRsl.g:1176:5: (lv_size_5_0= ruleDoubleOrInt )
                    {
                    // InternalRsl.g:1176:5: (lv_size_5_0= ruleDoubleOrInt )
                    // InternalRsl.g:1177:6: lv_size_5_0= ruleDoubleOrInt
                    {

                    						newCompositeNode(grammarAccess.getAttributeAccess().getSizeDoubleOrIntParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_36);
                    lv_size_5_0=ruleDoubleOrInt();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAttributeRule());
                    						}
                    						set(
                    							current,
                    							"size",
                    							lv_size_5_0,
                    							"org.rslingo.rsl.Rsl.DoubleOrInt");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_6=(Token)match(input,42,FOLLOW_16); 

                    				newLeafNode(otherlv_6, grammarAccess.getAttributeAccess().getRightParenthesisKeyword_4_2());
                    			

                    }
                    break;

            }

            otherlv_7=(Token)match(input,30,FOLLOW_17); 

            			newLeafNode(otherlv_7, grammarAccess.getAttributeAccess().getLeftSquareBracketKeyword_5());
            		
            // InternalRsl.g:1203:3: (otherlv_8= 'name' ( (lv_nameAlias_9_0= RULE_STRING ) ) )
            // InternalRsl.g:1204:4: otherlv_8= 'name' ( (lv_nameAlias_9_0= RULE_STRING ) )
            {
            otherlv_8=(Token)match(input,31,FOLLOW_18); 

            				newLeafNode(otherlv_8, grammarAccess.getAttributeAccess().getNameKeyword_6_0());
            			
            // InternalRsl.g:1208:4: ( (lv_nameAlias_9_0= RULE_STRING ) )
            // InternalRsl.g:1209:5: (lv_nameAlias_9_0= RULE_STRING )
            {
            // InternalRsl.g:1209:5: (lv_nameAlias_9_0= RULE_STRING )
            // InternalRsl.g:1210:6: lv_nameAlias_9_0= RULE_STRING
            {
            lv_nameAlias_9_0=(Token)match(input,RULE_STRING,FOLLOW_37); 

            						newLeafNode(lv_nameAlias_9_0, grammarAccess.getAttributeAccess().getNameAliasSTRINGTerminalRuleCall_6_1_0());
            					

            						if (current==null) {
            							current = createModelElement(grammarAccess.getAttributeRule());
            						}
            						setWithLastConsumed(
            							current,
            							"nameAlias",
            							lv_nameAlias_9_0,
            							"org.eclipse.xtext.common.Terminals.STRING");
            					

            }


            }


            }

            // InternalRsl.g:1227:3: (otherlv_10= 'multiplicity' ( (lv_multiplicity_11_0= ruleMultiplicity ) ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==43) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalRsl.g:1228:4: otherlv_10= 'multiplicity' ( (lv_multiplicity_11_0= ruleMultiplicity ) )
                    {
                    otherlv_10=(Token)match(input,43,FOLLOW_38); 

                    				newLeafNode(otherlv_10, grammarAccess.getAttributeAccess().getMultiplicityKeyword_7_0());
                    			
                    // InternalRsl.g:1232:4: ( (lv_multiplicity_11_0= ruleMultiplicity ) )
                    // InternalRsl.g:1233:5: (lv_multiplicity_11_0= ruleMultiplicity )
                    {
                    // InternalRsl.g:1233:5: (lv_multiplicity_11_0= ruleMultiplicity )
                    // InternalRsl.g:1234:6: lv_multiplicity_11_0= ruleMultiplicity
                    {

                    						newCompositeNode(grammarAccess.getAttributeAccess().getMultiplicityMultiplicityParserRuleCall_7_1_0());
                    					
                    pushFollow(FOLLOW_39);
                    lv_multiplicity_11_0=ruleMultiplicity();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAttributeRule());
                    						}
                    						set(
                    							current,
                    							"multiplicity",
                    							lv_multiplicity_11_0,
                    							"org.rslingo.rsl.Rsl.Multiplicity");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalRsl.g:1252:3: (otherlv_12= 'defaultValue' ( (lv_defaultValue_13_0= RULE_STRING ) ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==44) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalRsl.g:1253:4: otherlv_12= 'defaultValue' ( (lv_defaultValue_13_0= RULE_STRING ) )
                    {
                    otherlv_12=(Token)match(input,44,FOLLOW_18); 

                    				newLeafNode(otherlv_12, grammarAccess.getAttributeAccess().getDefaultValueKeyword_8_0());
                    			
                    // InternalRsl.g:1257:4: ( (lv_defaultValue_13_0= RULE_STRING ) )
                    // InternalRsl.g:1258:5: (lv_defaultValue_13_0= RULE_STRING )
                    {
                    // InternalRsl.g:1258:5: (lv_defaultValue_13_0= RULE_STRING )
                    // InternalRsl.g:1259:6: lv_defaultValue_13_0= RULE_STRING
                    {
                    lv_defaultValue_13_0=(Token)match(input,RULE_STRING,FOLLOW_40); 

                    						newLeafNode(lv_defaultValue_13_0, grammarAccess.getAttributeAccess().getDefaultValueSTRINGTerminalRuleCall_8_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAttributeRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"defaultValue",
                    							lv_defaultValue_13_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalRsl.g:1276:3: (otherlv_14= 'values' ( (lv_values_15_0= RULE_STRING ) ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==45) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalRsl.g:1277:4: otherlv_14= 'values' ( (lv_values_15_0= RULE_STRING ) )
                    {
                    otherlv_14=(Token)match(input,45,FOLLOW_18); 

                    				newLeafNode(otherlv_14, grammarAccess.getAttributeAccess().getValuesKeyword_9_0());
                    			
                    // InternalRsl.g:1281:4: ( (lv_values_15_0= RULE_STRING ) )
                    // InternalRsl.g:1282:5: (lv_values_15_0= RULE_STRING )
                    {
                    // InternalRsl.g:1282:5: (lv_values_15_0= RULE_STRING )
                    // InternalRsl.g:1283:6: lv_values_15_0= RULE_STRING
                    {
                    lv_values_15_0=(Token)match(input,RULE_STRING,FOLLOW_41); 

                    						newLeafNode(lv_values_15_0, grammarAccess.getAttributeAccess().getValuesSTRINGTerminalRuleCall_9_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAttributeRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"values",
                    							lv_values_15_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalRsl.g:1300:3: ( (lv_notNull_16_0= 'NotNull' ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==46) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalRsl.g:1301:4: (lv_notNull_16_0= 'NotNull' )
                    {
                    // InternalRsl.g:1301:4: (lv_notNull_16_0= 'NotNull' )
                    // InternalRsl.g:1302:5: lv_notNull_16_0= 'NotNull'
                    {
                    lv_notNull_16_0=(Token)match(input,46,FOLLOW_42); 

                    					newLeafNode(lv_notNull_16_0, grammarAccess.getAttributeAccess().getNotNullNotNullKeyword_10_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getAttributeRule());
                    					}
                    					setWithLastConsumed(current, "notNull", lv_notNull_16_0, "NotNull");
                    				

                    }


                    }
                    break;

            }

            // InternalRsl.g:1314:3: ( (lv_unique_17_0= 'Unique' ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==47) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalRsl.g:1315:4: (lv_unique_17_0= 'Unique' )
                    {
                    // InternalRsl.g:1315:4: (lv_unique_17_0= 'Unique' )
                    // InternalRsl.g:1316:5: lv_unique_17_0= 'Unique'
                    {
                    lv_unique_17_0=(Token)match(input,47,FOLLOW_23); 

                    					newLeafNode(lv_unique_17_0, grammarAccess.getAttributeAccess().getUniqueUniqueKeyword_11_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getAttributeRule());
                    					}
                    					setWithLastConsumed(current, "unique", lv_unique_17_0, "Unique");
                    				

                    }


                    }
                    break;

            }

            // InternalRsl.g:1328:3: (otherlv_18= 'description' ( (lv_description_19_0= RULE_STRING ) ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==35) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalRsl.g:1329:4: otherlv_18= 'description' ( (lv_description_19_0= RULE_STRING ) )
                    {
                    otherlv_18=(Token)match(input,35,FOLLOW_18); 

                    				newLeafNode(otherlv_18, grammarAccess.getAttributeAccess().getDescriptionKeyword_12_0());
                    			
                    // InternalRsl.g:1333:4: ( (lv_description_19_0= RULE_STRING ) )
                    // InternalRsl.g:1334:5: (lv_description_19_0= RULE_STRING )
                    {
                    // InternalRsl.g:1334:5: (lv_description_19_0= RULE_STRING )
                    // InternalRsl.g:1335:6: lv_description_19_0= RULE_STRING
                    {
                    lv_description_19_0=(Token)match(input,RULE_STRING,FOLLOW_24); 

                    						newLeafNode(lv_description_19_0, grammarAccess.getAttributeAccess().getDescriptionSTRINGTerminalRuleCall_12_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAttributeRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"description",
                    							lv_description_19_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_20=(Token)match(input,36,FOLLOW_2); 

            			newLeafNode(otherlv_20, grammarAccess.getAttributeAccess().getRightSquareBracketKeyword_13());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAttribute"


    // $ANTLR start "entryRuleMultiplicity"
    // InternalRsl.g:1360:1: entryRuleMultiplicity returns [EObject current=null] : iv_ruleMultiplicity= ruleMultiplicity EOF ;
    public final EObject entryRuleMultiplicity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicity = null;


        try {
            // InternalRsl.g:1360:53: (iv_ruleMultiplicity= ruleMultiplicity EOF )
            // InternalRsl.g:1361:2: iv_ruleMultiplicity= ruleMultiplicity EOF
            {
             newCompositeNode(grammarAccess.getMultiplicityRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMultiplicity=ruleMultiplicity();

            state._fsp--;

             current =iv_ruleMultiplicity; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMultiplicity"


    // $ANTLR start "ruleMultiplicity"
    // InternalRsl.g:1367:1: ruleMultiplicity returns [EObject current=null] : ( ( (lv_value_0_1= '\"0\"' | lv_value_0_2= '\"1\"' | lv_value_0_3= '\"0..1\"' | lv_value_0_4= '\"*\"' | lv_value_0_5= RULE_STRING ) ) ) ;
    public final EObject ruleMultiplicity() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_1=null;
        Token lv_value_0_2=null;
        Token lv_value_0_3=null;
        Token lv_value_0_4=null;
        Token lv_value_0_5=null;


        	enterRule();

        try {
            // InternalRsl.g:1373:2: ( ( ( (lv_value_0_1= '\"0\"' | lv_value_0_2= '\"1\"' | lv_value_0_3= '\"0..1\"' | lv_value_0_4= '\"*\"' | lv_value_0_5= RULE_STRING ) ) ) )
            // InternalRsl.g:1374:2: ( ( (lv_value_0_1= '\"0\"' | lv_value_0_2= '\"1\"' | lv_value_0_3= '\"0..1\"' | lv_value_0_4= '\"*\"' | lv_value_0_5= RULE_STRING ) ) )
            {
            // InternalRsl.g:1374:2: ( ( (lv_value_0_1= '\"0\"' | lv_value_0_2= '\"1\"' | lv_value_0_3= '\"0..1\"' | lv_value_0_4= '\"*\"' | lv_value_0_5= RULE_STRING ) ) )
            // InternalRsl.g:1375:3: ( (lv_value_0_1= '\"0\"' | lv_value_0_2= '\"1\"' | lv_value_0_3= '\"0..1\"' | lv_value_0_4= '\"*\"' | lv_value_0_5= RULE_STRING ) )
            {
            // InternalRsl.g:1375:3: ( (lv_value_0_1= '\"0\"' | lv_value_0_2= '\"1\"' | lv_value_0_3= '\"0..1\"' | lv_value_0_4= '\"*\"' | lv_value_0_5= RULE_STRING ) )
            // InternalRsl.g:1376:4: (lv_value_0_1= '\"0\"' | lv_value_0_2= '\"1\"' | lv_value_0_3= '\"0..1\"' | lv_value_0_4= '\"*\"' | lv_value_0_5= RULE_STRING )
            {
            // InternalRsl.g:1376:4: (lv_value_0_1= '\"0\"' | lv_value_0_2= '\"1\"' | lv_value_0_3= '\"0..1\"' | lv_value_0_4= '\"*\"' | lv_value_0_5= RULE_STRING )
            int alt32=5;
            switch ( input.LA(1) ) {
            case 48:
                {
                alt32=1;
                }
                break;
            case 49:
                {
                alt32=2;
                }
                break;
            case 50:
                {
                alt32=3;
                }
                break;
            case 51:
                {
                alt32=4;
                }
                break;
            case RULE_STRING:
                {
                alt32=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }

            switch (alt32) {
                case 1 :
                    // InternalRsl.g:1377:5: lv_value_0_1= '\"0\"'
                    {
                    lv_value_0_1=(Token)match(input,48,FOLLOW_2); 

                    					newLeafNode(lv_value_0_1, grammarAccess.getMultiplicityAccess().getValue0Keyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getMultiplicityRule());
                    					}
                    					setWithLastConsumed(current, "value", lv_value_0_1, null);
                    				

                    }
                    break;
                case 2 :
                    // InternalRsl.g:1388:5: lv_value_0_2= '\"1\"'
                    {
                    lv_value_0_2=(Token)match(input,49,FOLLOW_2); 

                    					newLeafNode(lv_value_0_2, grammarAccess.getMultiplicityAccess().getValue1Keyword_0_1());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getMultiplicityRule());
                    					}
                    					setWithLastConsumed(current, "value", lv_value_0_2, null);
                    				

                    }
                    break;
                case 3 :
                    // InternalRsl.g:1399:5: lv_value_0_3= '\"0..1\"'
                    {
                    lv_value_0_3=(Token)match(input,50,FOLLOW_2); 

                    					newLeafNode(lv_value_0_3, grammarAccess.getMultiplicityAccess().getValue01Keyword_0_2());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getMultiplicityRule());
                    					}
                    					setWithLastConsumed(current, "value", lv_value_0_3, null);
                    				

                    }
                    break;
                case 4 :
                    // InternalRsl.g:1410:5: lv_value_0_4= '\"*\"'
                    {
                    lv_value_0_4=(Token)match(input,51,FOLLOW_2); 

                    					newLeafNode(lv_value_0_4, grammarAccess.getMultiplicityAccess().getValueQuotationMarkAsteriskQuotationMarkKeyword_0_3());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getMultiplicityRule());
                    					}
                    					setWithLastConsumed(current, "value", lv_value_0_4, null);
                    				

                    }
                    break;
                case 5 :
                    // InternalRsl.g:1421:5: lv_value_0_5= RULE_STRING
                    {
                    lv_value_0_5=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    					newLeafNode(lv_value_0_5, grammarAccess.getMultiplicityAccess().getValueSTRINGTerminalRuleCall_0_4());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getMultiplicityRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"value",
                    						lv_value_0_5,
                    						"org.eclipse.xtext.common.Terminals.STRING");
                    				

                    }
                    break;

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiplicity"


    // $ANTLR start "entryRulePrimaryKey"
    // InternalRsl.g:1441:1: entryRulePrimaryKey returns [EObject current=null] : iv_rulePrimaryKey= rulePrimaryKey EOF ;
    public final EObject entryRulePrimaryKey() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryKey = null;


        try {
            // InternalRsl.g:1441:51: (iv_rulePrimaryKey= rulePrimaryKey EOF )
            // InternalRsl.g:1442:2: iv_rulePrimaryKey= rulePrimaryKey EOF
            {
             newCompositeNode(grammarAccess.getPrimaryKeyRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePrimaryKey=rulePrimaryKey();

            state._fsp--;

             current =iv_rulePrimaryKey; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimaryKey"


    // $ANTLR start "rulePrimaryKey"
    // InternalRsl.g:1448:1: rulePrimaryKey returns [EObject current=null] : (otherlv_0= 'primaryKey' otherlv_1= '(' ( (lv_refTo_2_0= ruleRefAttribute ) ) otherlv_3= ')' ) ;
    public final EObject rulePrimaryKey() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_refTo_2_0 = null;



        	enterRule();

        try {
            // InternalRsl.g:1454:2: ( (otherlv_0= 'primaryKey' otherlv_1= '(' ( (lv_refTo_2_0= ruleRefAttribute ) ) otherlv_3= ')' ) )
            // InternalRsl.g:1455:2: (otherlv_0= 'primaryKey' otherlv_1= '(' ( (lv_refTo_2_0= ruleRefAttribute ) ) otherlv_3= ')' )
            {
            // InternalRsl.g:1455:2: (otherlv_0= 'primaryKey' otherlv_1= '(' ( (lv_refTo_2_0= ruleRefAttribute ) ) otherlv_3= ')' )
            // InternalRsl.g:1456:3: otherlv_0= 'primaryKey' otherlv_1= '(' ( (lv_refTo_2_0= ruleRefAttribute ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,52,FOLLOW_43); 

            			newLeafNode(otherlv_0, grammarAccess.getPrimaryKeyAccess().getPrimaryKeyKeyword_0());
            		
            otherlv_1=(Token)match(input,41,FOLLOW_5); 

            			newLeafNode(otherlv_1, grammarAccess.getPrimaryKeyAccess().getLeftParenthesisKeyword_1());
            		
            // InternalRsl.g:1464:3: ( (lv_refTo_2_0= ruleRefAttribute ) )
            // InternalRsl.g:1465:4: (lv_refTo_2_0= ruleRefAttribute )
            {
            // InternalRsl.g:1465:4: (lv_refTo_2_0= ruleRefAttribute )
            // InternalRsl.g:1466:5: lv_refTo_2_0= ruleRefAttribute
            {

            					newCompositeNode(grammarAccess.getPrimaryKeyAccess().getRefToRefAttributeParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_36);
            lv_refTo_2_0=ruleRefAttribute();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPrimaryKeyRule());
            					}
            					set(
            						current,
            						"refTo",
            						lv_refTo_2_0,
            						"org.rslingo.rsl.Rsl.RefAttribute");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,42,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getPrimaryKeyAccess().getRightParenthesisKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimaryKey"


    // $ANTLR start "entryRuleForeignKey"
    // InternalRsl.g:1491:1: entryRuleForeignKey returns [EObject current=null] : iv_ruleForeignKey= ruleForeignKey EOF ;
    public final EObject entryRuleForeignKey() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForeignKey = null;


        try {
            // InternalRsl.g:1491:51: (iv_ruleForeignKey= ruleForeignKey EOF )
            // InternalRsl.g:1492:2: iv_ruleForeignKey= ruleForeignKey EOF
            {
             newCompositeNode(grammarAccess.getForeignKeyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleForeignKey=ruleForeignKey();

            state._fsp--;

             current =iv_ruleForeignKey; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleForeignKey"


    // $ANTLR start "ruleForeignKey"
    // InternalRsl.g:1498:1: ruleForeignKey returns [EObject current=null] : (otherlv_0= 'foreignKey' ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( (lv_refTo_3_0= ruleRefAttribute ) ) otherlv_4= ')' ) ;
    public final EObject ruleForeignKey() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_refTo_3_0 = null;



        	enterRule();

        try {
            // InternalRsl.g:1504:2: ( (otherlv_0= 'foreignKey' ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( (lv_refTo_3_0= ruleRefAttribute ) ) otherlv_4= ')' ) )
            // InternalRsl.g:1505:2: (otherlv_0= 'foreignKey' ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( (lv_refTo_3_0= ruleRefAttribute ) ) otherlv_4= ')' )
            {
            // InternalRsl.g:1505:2: (otherlv_0= 'foreignKey' ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( (lv_refTo_3_0= ruleRefAttribute ) ) otherlv_4= ')' )
            // InternalRsl.g:1506:3: otherlv_0= 'foreignKey' ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( (lv_refTo_3_0= ruleRefAttribute ) ) otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,53,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getForeignKeyAccess().getForeignKeyKeyword_0());
            		
            // InternalRsl.g:1510:3: ( (otherlv_1= RULE_ID ) )
            // InternalRsl.g:1511:4: (otherlv_1= RULE_ID )
            {
            // InternalRsl.g:1511:4: (otherlv_1= RULE_ID )
            // InternalRsl.g:1512:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getForeignKeyRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_43); 

            					newLeafNode(otherlv_1, grammarAccess.getForeignKeyAccess().getFentityDataEntityCrossReference_1_0());
            				

            }


            }

            otherlv_2=(Token)match(input,41,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getForeignKeyAccess().getLeftParenthesisKeyword_2());
            		
            // InternalRsl.g:1527:3: ( (lv_refTo_3_0= ruleRefAttribute ) )
            // InternalRsl.g:1528:4: (lv_refTo_3_0= ruleRefAttribute )
            {
            // InternalRsl.g:1528:4: (lv_refTo_3_0= ruleRefAttribute )
            // InternalRsl.g:1529:5: lv_refTo_3_0= ruleRefAttribute
            {

            					newCompositeNode(grammarAccess.getForeignKeyAccess().getRefToRefAttributeParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_36);
            lv_refTo_3_0=ruleRefAttribute();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getForeignKeyRule());
            					}
            					set(
            						current,
            						"refTo",
            						lv_refTo_3_0,
            						"org.rslingo.rsl.Rsl.RefAttribute");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,42,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getForeignKeyAccess().getRightParenthesisKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleForeignKey"


    // $ANTLR start "entryRuleRefAttribute"
    // InternalRsl.g:1554:1: entryRuleRefAttribute returns [EObject current=null] : iv_ruleRefAttribute= ruleRefAttribute EOF ;
    public final EObject entryRuleRefAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefAttribute = null;


        try {
            // InternalRsl.g:1554:53: (iv_ruleRefAttribute= ruleRefAttribute EOF )
            // InternalRsl.g:1555:2: iv_ruleRefAttribute= ruleRefAttribute EOF
            {
             newCompositeNode(grammarAccess.getRefAttributeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRefAttribute=ruleRefAttribute();

            state._fsp--;

             current =iv_ruleRefAttribute; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRefAttribute"


    // $ANTLR start "ruleRefAttribute"
    // InternalRsl.g:1561:1: ruleRefAttribute returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= ',' ( (otherlv_2= RULE_ID ) ) )* ) ;
    public final EObject ruleRefAttribute() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalRsl.g:1567:2: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= ',' ( (otherlv_2= RULE_ID ) ) )* ) )
            // InternalRsl.g:1568:2: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= ',' ( (otherlv_2= RULE_ID ) ) )* )
            {
            // InternalRsl.g:1568:2: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= ',' ( (otherlv_2= RULE_ID ) ) )* )
            // InternalRsl.g:1569:3: ( (otherlv_0= RULE_ID ) ) (otherlv_1= ',' ( (otherlv_2= RULE_ID ) ) )*
            {
            // InternalRsl.g:1569:3: ( (otherlv_0= RULE_ID ) )
            // InternalRsl.g:1570:4: (otherlv_0= RULE_ID )
            {
            // InternalRsl.g:1570:4: (otherlv_0= RULE_ID )
            // InternalRsl.g:1571:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRefAttributeRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_25); 

            					newLeafNode(otherlv_0, grammarAccess.getRefAttributeAccess().getRefAttrAttributeCrossReference_0_0());
            				

            }


            }

            // InternalRsl.g:1582:3: (otherlv_1= ',' ( (otherlv_2= RULE_ID ) ) )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==37) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalRsl.g:1583:4: otherlv_1= ',' ( (otherlv_2= RULE_ID ) )
            	    {
            	    otherlv_1=(Token)match(input,37,FOLLOW_5); 

            	    				newLeafNode(otherlv_1, grammarAccess.getRefAttributeAccess().getCommaKeyword_1_0());
            	    			
            	    // InternalRsl.g:1587:4: ( (otherlv_2= RULE_ID ) )
            	    // InternalRsl.g:1588:5: (otherlv_2= RULE_ID )
            	    {
            	    // InternalRsl.g:1588:5: (otherlv_2= RULE_ID )
            	    // InternalRsl.g:1589:6: otherlv_2= RULE_ID
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getRefAttributeRule());
            	    						}
            	    					
            	    otherlv_2=(Token)match(input,RULE_ID,FOLLOW_25); 

            	    						newLeafNode(otherlv_2, grammarAccess.getRefAttributeAccess().getRefAttrAttributeCrossReference_1_1_0());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRefAttribute"


    // $ANTLR start "entryRuleCheck"
    // InternalRsl.g:1605:1: entryRuleCheck returns [EObject current=null] : iv_ruleCheck= ruleCheck EOF ;
    public final EObject entryRuleCheck() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCheck = null;


        try {
            // InternalRsl.g:1605:46: (iv_ruleCheck= ruleCheck EOF )
            // InternalRsl.g:1606:2: iv_ruleCheck= ruleCheck EOF
            {
             newCompositeNode(grammarAccess.getCheckRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCheck=ruleCheck();

            state._fsp--;

             current =iv_ruleCheck; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCheck"


    // $ANTLR start "ruleCheck"
    // InternalRsl.g:1612:1: ruleCheck returns [EObject current=null] : (otherlv_0= 'check' ( (lv_name_1_0= RULE_ID ) ) ( (lv_checkExpression_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleCheck() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token lv_checkExpression_2_0=null;


        	enterRule();

        try {
            // InternalRsl.g:1618:2: ( (otherlv_0= 'check' ( (lv_name_1_0= RULE_ID ) ) ( (lv_checkExpression_2_0= RULE_STRING ) ) ) )
            // InternalRsl.g:1619:2: (otherlv_0= 'check' ( (lv_name_1_0= RULE_ID ) ) ( (lv_checkExpression_2_0= RULE_STRING ) ) )
            {
            // InternalRsl.g:1619:2: (otherlv_0= 'check' ( (lv_name_1_0= RULE_ID ) ) ( (lv_checkExpression_2_0= RULE_STRING ) ) )
            // InternalRsl.g:1620:3: otherlv_0= 'check' ( (lv_name_1_0= RULE_ID ) ) ( (lv_checkExpression_2_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,54,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getCheckAccess().getCheckKeyword_0());
            		
            // InternalRsl.g:1624:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalRsl.g:1625:4: (lv_name_1_0= RULE_ID )
            {
            // InternalRsl.g:1625:4: (lv_name_1_0= RULE_ID )
            // InternalRsl.g:1626:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_18); 

            					newLeafNode(lv_name_1_0, grammarAccess.getCheckAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCheckRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalRsl.g:1642:3: ( (lv_checkExpression_2_0= RULE_STRING ) )
            // InternalRsl.g:1643:4: (lv_checkExpression_2_0= RULE_STRING )
            {
            // InternalRsl.g:1643:4: (lv_checkExpression_2_0= RULE_STRING )
            // InternalRsl.g:1644:5: lv_checkExpression_2_0= RULE_STRING
            {
            lv_checkExpression_2_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_checkExpression_2_0, grammarAccess.getCheckAccess().getCheckExpressionSTRINGTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCheckRule());
            					}
            					setWithLastConsumed(
            						current,
            						"checkExpression",
            						lv_checkExpression_2_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCheck"


    // $ANTLR start "entryRuleDataEntityView"
    // InternalRsl.g:1664:1: entryRuleDataEntityView returns [EObject current=null] : iv_ruleDataEntityView= ruleDataEntityView EOF ;
    public final EObject entryRuleDataEntityView() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataEntityView = null;


        try {
            // InternalRsl.g:1664:55: (iv_ruleDataEntityView= ruleDataEntityView EOF )
            // InternalRsl.g:1665:2: iv_ruleDataEntityView= ruleDataEntityView EOF
            {
             newCompositeNode(grammarAccess.getDataEntityViewRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDataEntityView=ruleDataEntityView();

            state._fsp--;

             current =iv_ruleDataEntityView; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDataEntityView"


    // $ANTLR start "ruleDataEntityView"
    // InternalRsl.g:1671:1: ruleDataEntityView returns [EObject current=null] : (otherlv_0= 'dataEntityView' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleDataEntityViewType ) ) otherlv_4= '[' (otherlv_5= 'name' ( (lv_nameAlias_6_0= RULE_STRING ) ) ) ( (lv_master_7_0= ruleMasterDEntity ) ) ( (lv_details_8_0= ruleDetailDEntity ) )* ( (lv_references_9_0= ruleReferenceDEntity ) )* (otherlv_10= 'description' ( (lv_description_11_0= RULE_STRING ) ) )? otherlv_12= ']' ) ;
    public final EObject ruleDataEntityView() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token lv_nameAlias_6_0=null;
        Token otherlv_10=null;
        Token lv_description_11_0=null;
        Token otherlv_12=null;
        Enumerator lv_type_3_0 = null;

        EObject lv_master_7_0 = null;

        EObject lv_details_8_0 = null;

        EObject lv_references_9_0 = null;



        	enterRule();

        try {
            // InternalRsl.g:1677:2: ( (otherlv_0= 'dataEntityView' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleDataEntityViewType ) ) otherlv_4= '[' (otherlv_5= 'name' ( (lv_nameAlias_6_0= RULE_STRING ) ) ) ( (lv_master_7_0= ruleMasterDEntity ) ) ( (lv_details_8_0= ruleDetailDEntity ) )* ( (lv_references_9_0= ruleReferenceDEntity ) )* (otherlv_10= 'description' ( (lv_description_11_0= RULE_STRING ) ) )? otherlv_12= ']' ) )
            // InternalRsl.g:1678:2: (otherlv_0= 'dataEntityView' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleDataEntityViewType ) ) otherlv_4= '[' (otherlv_5= 'name' ( (lv_nameAlias_6_0= RULE_STRING ) ) ) ( (lv_master_7_0= ruleMasterDEntity ) ) ( (lv_details_8_0= ruleDetailDEntity ) )* ( (lv_references_9_0= ruleReferenceDEntity ) )* (otherlv_10= 'description' ( (lv_description_11_0= RULE_STRING ) ) )? otherlv_12= ']' )
            {
            // InternalRsl.g:1678:2: (otherlv_0= 'dataEntityView' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleDataEntityViewType ) ) otherlv_4= '[' (otherlv_5= 'name' ( (lv_nameAlias_6_0= RULE_STRING ) ) ) ( (lv_master_7_0= ruleMasterDEntity ) ) ( (lv_details_8_0= ruleDetailDEntity ) )* ( (lv_references_9_0= ruleReferenceDEntity ) )* (otherlv_10= 'description' ( (lv_description_11_0= RULE_STRING ) ) )? otherlv_12= ']' )
            // InternalRsl.g:1679:3: otherlv_0= 'dataEntityView' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleDataEntityViewType ) ) otherlv_4= '[' (otherlv_5= 'name' ( (lv_nameAlias_6_0= RULE_STRING ) ) ) ( (lv_master_7_0= ruleMasterDEntity ) ) ( (lv_details_8_0= ruleDetailDEntity ) )* ( (lv_references_9_0= ruleReferenceDEntity ) )* (otherlv_10= 'description' ( (lv_description_11_0= RULE_STRING ) ) )? otherlv_12= ']'
            {
            otherlv_0=(Token)match(input,55,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getDataEntityViewAccess().getDataEntityViewKeyword_0());
            		
            // InternalRsl.g:1683:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalRsl.g:1684:4: (lv_name_1_0= RULE_ID )
            {
            // InternalRsl.g:1684:4: (lv_name_1_0= RULE_ID )
            // InternalRsl.g:1685:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_14); 

            					newLeafNode(lv_name_1_0, grammarAccess.getDataEntityViewAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDataEntityViewRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,29,FOLLOW_44); 

            			newLeafNode(otherlv_2, grammarAccess.getDataEntityViewAccess().getColonKeyword_2());
            		
            // InternalRsl.g:1705:3: ( (lv_type_3_0= ruleDataEntityViewType ) )
            // InternalRsl.g:1706:4: (lv_type_3_0= ruleDataEntityViewType )
            {
            // InternalRsl.g:1706:4: (lv_type_3_0= ruleDataEntityViewType )
            // InternalRsl.g:1707:5: lv_type_3_0= ruleDataEntityViewType
            {

            					newCompositeNode(grammarAccess.getDataEntityViewAccess().getTypeDataEntityViewTypeEnumRuleCall_3_0());
            				
            pushFollow(FOLLOW_16);
            lv_type_3_0=ruleDataEntityViewType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDataEntityViewRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_3_0,
            						"org.rslingo.rsl.Rsl.DataEntityViewType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,30,FOLLOW_17); 

            			newLeafNode(otherlv_4, grammarAccess.getDataEntityViewAccess().getLeftSquareBracketKeyword_4());
            		
            // InternalRsl.g:1728:3: (otherlv_5= 'name' ( (lv_nameAlias_6_0= RULE_STRING ) ) )
            // InternalRsl.g:1729:4: otherlv_5= 'name' ( (lv_nameAlias_6_0= RULE_STRING ) )
            {
            otherlv_5=(Token)match(input,31,FOLLOW_18); 

            				newLeafNode(otherlv_5, grammarAccess.getDataEntityViewAccess().getNameKeyword_5_0());
            			
            // InternalRsl.g:1733:4: ( (lv_nameAlias_6_0= RULE_STRING ) )
            // InternalRsl.g:1734:5: (lv_nameAlias_6_0= RULE_STRING )
            {
            // InternalRsl.g:1734:5: (lv_nameAlias_6_0= RULE_STRING )
            // InternalRsl.g:1735:6: lv_nameAlias_6_0= RULE_STRING
            {
            lv_nameAlias_6_0=(Token)match(input,RULE_STRING,FOLLOW_45); 

            						newLeafNode(lv_nameAlias_6_0, grammarAccess.getDataEntityViewAccess().getNameAliasSTRINGTerminalRuleCall_5_1_0());
            					

            						if (current==null) {
            							current = createModelElement(grammarAccess.getDataEntityViewRule());
            						}
            						setWithLastConsumed(
            							current,
            							"nameAlias",
            							lv_nameAlias_6_0,
            							"org.eclipse.xtext.common.Terminals.STRING");
            					

            }


            }


            }

            // InternalRsl.g:1752:3: ( (lv_master_7_0= ruleMasterDEntity ) )
            // InternalRsl.g:1753:4: (lv_master_7_0= ruleMasterDEntity )
            {
            // InternalRsl.g:1753:4: (lv_master_7_0= ruleMasterDEntity )
            // InternalRsl.g:1754:5: lv_master_7_0= ruleMasterDEntity
            {

            					newCompositeNode(grammarAccess.getDataEntityViewAccess().getMasterMasterDEntityParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_46);
            lv_master_7_0=ruleMasterDEntity();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDataEntityViewRule());
            					}
            					set(
            						current,
            						"master",
            						lv_master_7_0,
            						"org.rslingo.rsl.Rsl.MasterDEntity");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRsl.g:1771:3: ( (lv_details_8_0= ruleDetailDEntity ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==57) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalRsl.g:1772:4: (lv_details_8_0= ruleDetailDEntity )
            	    {
            	    // InternalRsl.g:1772:4: (lv_details_8_0= ruleDetailDEntity )
            	    // InternalRsl.g:1773:5: lv_details_8_0= ruleDetailDEntity
            	    {

            	    					newCompositeNode(grammarAccess.getDataEntityViewAccess().getDetailsDetailDEntityParserRuleCall_7_0());
            	    				
            	    pushFollow(FOLLOW_46);
            	    lv_details_8_0=ruleDetailDEntity();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getDataEntityViewRule());
            	    					}
            	    					add(
            	    						current,
            	    						"details",
            	    						lv_details_8_0,
            	    						"org.rslingo.rsl.Rsl.DetailDEntity");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);

            // InternalRsl.g:1790:3: ( (lv_references_9_0= ruleReferenceDEntity ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==58) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalRsl.g:1791:4: (lv_references_9_0= ruleReferenceDEntity )
            	    {
            	    // InternalRsl.g:1791:4: (lv_references_9_0= ruleReferenceDEntity )
            	    // InternalRsl.g:1792:5: lv_references_9_0= ruleReferenceDEntity
            	    {

            	    					newCompositeNode(grammarAccess.getDataEntityViewAccess().getReferencesReferenceDEntityParserRuleCall_8_0());
            	    				
            	    pushFollow(FOLLOW_47);
            	    lv_references_9_0=ruleReferenceDEntity();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getDataEntityViewRule());
            	    					}
            	    					add(
            	    						current,
            	    						"references",
            	    						lv_references_9_0,
            	    						"org.rslingo.rsl.Rsl.ReferenceDEntity");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);

            // InternalRsl.g:1809:3: (otherlv_10= 'description' ( (lv_description_11_0= RULE_STRING ) ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==35) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalRsl.g:1810:4: otherlv_10= 'description' ( (lv_description_11_0= RULE_STRING ) )
                    {
                    otherlv_10=(Token)match(input,35,FOLLOW_18); 

                    				newLeafNode(otherlv_10, grammarAccess.getDataEntityViewAccess().getDescriptionKeyword_9_0());
                    			
                    // InternalRsl.g:1814:4: ( (lv_description_11_0= RULE_STRING ) )
                    // InternalRsl.g:1815:5: (lv_description_11_0= RULE_STRING )
                    {
                    // InternalRsl.g:1815:5: (lv_description_11_0= RULE_STRING )
                    // InternalRsl.g:1816:6: lv_description_11_0= RULE_STRING
                    {
                    lv_description_11_0=(Token)match(input,RULE_STRING,FOLLOW_24); 

                    						newLeafNode(lv_description_11_0, grammarAccess.getDataEntityViewAccess().getDescriptionSTRINGTerminalRuleCall_9_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDataEntityViewRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"description",
                    							lv_description_11_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_12=(Token)match(input,36,FOLLOW_2); 

            			newLeafNode(otherlv_12, grammarAccess.getDataEntityViewAccess().getRightSquareBracketKeyword_10());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDataEntityView"


    // $ANTLR start "entryRuleMasterDEntity"
    // InternalRsl.g:1841:1: entryRuleMasterDEntity returns [EObject current=null] : iv_ruleMasterDEntity= ruleMasterDEntity EOF ;
    public final EObject entryRuleMasterDEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMasterDEntity = null;


        try {
            // InternalRsl.g:1841:54: (iv_ruleMasterDEntity= ruleMasterDEntity EOF )
            // InternalRsl.g:1842:2: iv_ruleMasterDEntity= ruleMasterDEntity EOF
            {
             newCompositeNode(grammarAccess.getMasterDEntityRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMasterDEntity=ruleMasterDEntity();

            state._fsp--;

             current =iv_ruleMasterDEntity; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMasterDEntity"


    // $ANTLR start "ruleMasterDEntity"
    // InternalRsl.g:1848:1: ruleMasterDEntity returns [EObject current=null] : (otherlv_0= 'master' ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleMasterDEntity() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRsl.g:1854:2: ( (otherlv_0= 'master' ( (otherlv_1= RULE_ID ) ) ) )
            // InternalRsl.g:1855:2: (otherlv_0= 'master' ( (otherlv_1= RULE_ID ) ) )
            {
            // InternalRsl.g:1855:2: (otherlv_0= 'master' ( (otherlv_1= RULE_ID ) ) )
            // InternalRsl.g:1856:3: otherlv_0= 'master' ( (otherlv_1= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,56,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getMasterDEntityAccess().getMasterKeyword_0());
            		
            // InternalRsl.g:1860:3: ( (otherlv_1= RULE_ID ) )
            // InternalRsl.g:1861:4: (otherlv_1= RULE_ID )
            {
            // InternalRsl.g:1861:4: (otherlv_1= RULE_ID )
            // InternalRsl.g:1862:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMasterDEntityRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(otherlv_1, grammarAccess.getMasterDEntityAccess().getMasterDEntityDataEntityCrossReference_1_0());
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMasterDEntity"


    // $ANTLR start "entryRuleDetailDEntity"
    // InternalRsl.g:1877:1: entryRuleDetailDEntity returns [EObject current=null] : iv_ruleDetailDEntity= ruleDetailDEntity EOF ;
    public final EObject entryRuleDetailDEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDetailDEntity = null;


        try {
            // InternalRsl.g:1877:54: (iv_ruleDetailDEntity= ruleDetailDEntity EOF )
            // InternalRsl.g:1878:2: iv_ruleDetailDEntity= ruleDetailDEntity EOF
            {
             newCompositeNode(grammarAccess.getDetailDEntityRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDetailDEntity=ruleDetailDEntity();

            state._fsp--;

             current =iv_ruleDetailDEntity; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDetailDEntity"


    // $ANTLR start "ruleDetailDEntity"
    // InternalRsl.g:1884:1: ruleDetailDEntity returns [EObject current=null] : (otherlv_0= 'detail' ( (otherlv_1= RULE_ID ) ) (otherlv_2= '[' otherlv_3= 'reference' ( (lv_refDEntity_4_0= ruleRefDEntity ) ) otherlv_5= ']' )? ) ;
    public final EObject ruleDetailDEntity() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_refDEntity_4_0 = null;



        	enterRule();

        try {
            // InternalRsl.g:1890:2: ( (otherlv_0= 'detail' ( (otherlv_1= RULE_ID ) ) (otherlv_2= '[' otherlv_3= 'reference' ( (lv_refDEntity_4_0= ruleRefDEntity ) ) otherlv_5= ']' )? ) )
            // InternalRsl.g:1891:2: (otherlv_0= 'detail' ( (otherlv_1= RULE_ID ) ) (otherlv_2= '[' otherlv_3= 'reference' ( (lv_refDEntity_4_0= ruleRefDEntity ) ) otherlv_5= ']' )? )
            {
            // InternalRsl.g:1891:2: (otherlv_0= 'detail' ( (otherlv_1= RULE_ID ) ) (otherlv_2= '[' otherlv_3= 'reference' ( (lv_refDEntity_4_0= ruleRefDEntity ) ) otherlv_5= ']' )? )
            // InternalRsl.g:1892:3: otherlv_0= 'detail' ( (otherlv_1= RULE_ID ) ) (otherlv_2= '[' otherlv_3= 'reference' ( (lv_refDEntity_4_0= ruleRefDEntity ) ) otherlv_5= ']' )?
            {
            otherlv_0=(Token)match(input,57,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getDetailDEntityAccess().getDetailKeyword_0());
            		
            // InternalRsl.g:1896:3: ( (otherlv_1= RULE_ID ) )
            // InternalRsl.g:1897:4: (otherlv_1= RULE_ID )
            {
            // InternalRsl.g:1897:4: (otherlv_1= RULE_ID )
            // InternalRsl.g:1898:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDetailDEntityRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_48); 

            					newLeafNode(otherlv_1, grammarAccess.getDetailDEntityAccess().getDEntityDetailDataEntityCrossReference_1_0());
            				

            }


            }

            // InternalRsl.g:1909:3: (otherlv_2= '[' otherlv_3= 'reference' ( (lv_refDEntity_4_0= ruleRefDEntity ) ) otherlv_5= ']' )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==30) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalRsl.g:1910:4: otherlv_2= '[' otherlv_3= 'reference' ( (lv_refDEntity_4_0= ruleRefDEntity ) ) otherlv_5= ']'
                    {
                    otherlv_2=(Token)match(input,30,FOLLOW_49); 

                    				newLeafNode(otherlv_2, grammarAccess.getDetailDEntityAccess().getLeftSquareBracketKeyword_2_0());
                    			
                    otherlv_3=(Token)match(input,58,FOLLOW_5); 

                    				newLeafNode(otherlv_3, grammarAccess.getDetailDEntityAccess().getReferenceKeyword_2_1());
                    			
                    // InternalRsl.g:1918:4: ( (lv_refDEntity_4_0= ruleRefDEntity ) )
                    // InternalRsl.g:1919:5: (lv_refDEntity_4_0= ruleRefDEntity )
                    {
                    // InternalRsl.g:1919:5: (lv_refDEntity_4_0= ruleRefDEntity )
                    // InternalRsl.g:1920:6: lv_refDEntity_4_0= ruleRefDEntity
                    {

                    						newCompositeNode(grammarAccess.getDetailDEntityAccess().getRefDEntityRefDEntityParserRuleCall_2_2_0());
                    					
                    pushFollow(FOLLOW_24);
                    lv_refDEntity_4_0=ruleRefDEntity();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDetailDEntityRule());
                    						}
                    						set(
                    							current,
                    							"refDEntity",
                    							lv_refDEntity_4_0,
                    							"org.rslingo.rsl.Rsl.RefDEntity");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_5=(Token)match(input,36,FOLLOW_2); 

                    				newLeafNode(otherlv_5, grammarAccess.getDetailDEntityAccess().getRightSquareBracketKeyword_2_3());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDetailDEntity"


    // $ANTLR start "entryRuleReferenceDEntity"
    // InternalRsl.g:1946:1: entryRuleReferenceDEntity returns [EObject current=null] : iv_ruleReferenceDEntity= ruleReferenceDEntity EOF ;
    public final EObject entryRuleReferenceDEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceDEntity = null;


        try {
            // InternalRsl.g:1946:57: (iv_ruleReferenceDEntity= ruleReferenceDEntity EOF )
            // InternalRsl.g:1947:2: iv_ruleReferenceDEntity= ruleReferenceDEntity EOF
            {
             newCompositeNode(grammarAccess.getReferenceDEntityRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleReferenceDEntity=ruleReferenceDEntity();

            state._fsp--;

             current =iv_ruleReferenceDEntity; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReferenceDEntity"


    // $ANTLR start "ruleReferenceDEntity"
    // InternalRsl.g:1953:1: ruleReferenceDEntity returns [EObject current=null] : (otherlv_0= 'reference' ( (lv_refDEntity_1_0= ruleRefDEntity ) ) ) ;
    public final EObject ruleReferenceDEntity() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_refDEntity_1_0 = null;



        	enterRule();

        try {
            // InternalRsl.g:1959:2: ( (otherlv_0= 'reference' ( (lv_refDEntity_1_0= ruleRefDEntity ) ) ) )
            // InternalRsl.g:1960:2: (otherlv_0= 'reference' ( (lv_refDEntity_1_0= ruleRefDEntity ) ) )
            {
            // InternalRsl.g:1960:2: (otherlv_0= 'reference' ( (lv_refDEntity_1_0= ruleRefDEntity ) ) )
            // InternalRsl.g:1961:3: otherlv_0= 'reference' ( (lv_refDEntity_1_0= ruleRefDEntity ) )
            {
            otherlv_0=(Token)match(input,58,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getReferenceDEntityAccess().getReferenceKeyword_0());
            		
            // InternalRsl.g:1965:3: ( (lv_refDEntity_1_0= ruleRefDEntity ) )
            // InternalRsl.g:1966:4: (lv_refDEntity_1_0= ruleRefDEntity )
            {
            // InternalRsl.g:1966:4: (lv_refDEntity_1_0= ruleRefDEntity )
            // InternalRsl.g:1967:5: lv_refDEntity_1_0= ruleRefDEntity
            {

            					newCompositeNode(grammarAccess.getReferenceDEntityAccess().getRefDEntityRefDEntityParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_refDEntity_1_0=ruleRefDEntity();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getReferenceDEntityRule());
            					}
            					set(
            						current,
            						"refDEntity",
            						lv_refDEntity_1_0,
            						"org.rslingo.rsl.Rsl.RefDEntity");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReferenceDEntity"


    // $ANTLR start "entryRuleRefDEntity"
    // InternalRsl.g:1988:1: entryRuleRefDEntity returns [EObject current=null] : iv_ruleRefDEntity= ruleRefDEntity EOF ;
    public final EObject entryRuleRefDEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefDEntity = null;


        try {
            // InternalRsl.g:1988:51: (iv_ruleRefDEntity= ruleRefDEntity EOF )
            // InternalRsl.g:1989:2: iv_ruleRefDEntity= ruleRefDEntity EOF
            {
             newCompositeNode(grammarAccess.getRefDEntityRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRefDEntity=ruleRefDEntity();

            state._fsp--;

             current =iv_ruleRefDEntity; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRefDEntity"


    // $ANTLR start "ruleRefDEntity"
    // InternalRsl.g:1995:1: ruleRefDEntity returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= ',' ( (otherlv_2= RULE_ID ) ) )* ) ;
    public final EObject ruleRefDEntity() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalRsl.g:2001:2: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= ',' ( (otherlv_2= RULE_ID ) ) )* ) )
            // InternalRsl.g:2002:2: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= ',' ( (otherlv_2= RULE_ID ) ) )* )
            {
            // InternalRsl.g:2002:2: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= ',' ( (otherlv_2= RULE_ID ) ) )* )
            // InternalRsl.g:2003:3: ( (otherlv_0= RULE_ID ) ) (otherlv_1= ',' ( (otherlv_2= RULE_ID ) ) )*
            {
            // InternalRsl.g:2003:3: ( (otherlv_0= RULE_ID ) )
            // InternalRsl.g:2004:4: (otherlv_0= RULE_ID )
            {
            // InternalRsl.g:2004:4: (otherlv_0= RULE_ID )
            // InternalRsl.g:2005:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRefDEntityRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_25); 

            					newLeafNode(otherlv_0, grammarAccess.getRefDEntityAccess().getRefDEntityDataEntityCrossReference_0_0());
            				

            }


            }

            // InternalRsl.g:2016:3: (otherlv_1= ',' ( (otherlv_2= RULE_ID ) ) )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==37) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // InternalRsl.g:2017:4: otherlv_1= ',' ( (otherlv_2= RULE_ID ) )
            	    {
            	    otherlv_1=(Token)match(input,37,FOLLOW_5); 

            	    				newLeafNode(otherlv_1, grammarAccess.getRefDEntityAccess().getCommaKeyword_1_0());
            	    			
            	    // InternalRsl.g:2021:4: ( (otherlv_2= RULE_ID ) )
            	    // InternalRsl.g:2022:5: (otherlv_2= RULE_ID )
            	    {
            	    // InternalRsl.g:2022:5: (otherlv_2= RULE_ID )
            	    // InternalRsl.g:2023:6: otherlv_2= RULE_ID
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getRefDEntityRule());
            	    						}
            	    					
            	    otherlv_2=(Token)match(input,RULE_ID,FOLLOW_25); 

            	    						newLeafNode(otherlv_2, grammarAccess.getRefDEntityAccess().getRefDEntityDataEntityCrossReference_1_1_0());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRefDEntity"


    // $ANTLR start "entryRuleActor"
    // InternalRsl.g:2039:1: entryRuleActor returns [EObject current=null] : iv_ruleActor= ruleActor EOF ;
    public final EObject entryRuleActor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActor = null;


        try {
            // InternalRsl.g:2039:46: (iv_ruleActor= ruleActor EOF )
            // InternalRsl.g:2040:2: iv_ruleActor= ruleActor EOF
            {
             newCompositeNode(grammarAccess.getActorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleActor=ruleActor();

            state._fsp--;

             current =iv_ruleActor; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleActor"


    // $ANTLR start "ruleActor"
    // InternalRsl.g:2046:1: ruleActor returns [EObject current=null] : (otherlv_0= 'actor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleActorType ) ) otherlv_4= '[' (otherlv_5= 'name' ( (lv_nameAlias_6_0= RULE_STRING ) ) ) (otherlv_7= 'isA' ( (otherlv_8= RULE_ID ) ) )? (otherlv_9= 'description' ( (lv_description_10_0= RULE_STRING ) ) )? otherlv_11= ']' ) ;
    public final EObject ruleActor() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token lv_nameAlias_6_0=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token lv_description_10_0=null;
        Token otherlv_11=null;
        Enumerator lv_type_3_0 = null;



        	enterRule();

        try {
            // InternalRsl.g:2052:2: ( (otherlv_0= 'actor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleActorType ) ) otherlv_4= '[' (otherlv_5= 'name' ( (lv_nameAlias_6_0= RULE_STRING ) ) ) (otherlv_7= 'isA' ( (otherlv_8= RULE_ID ) ) )? (otherlv_9= 'description' ( (lv_description_10_0= RULE_STRING ) ) )? otherlv_11= ']' ) )
            // InternalRsl.g:2053:2: (otherlv_0= 'actor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleActorType ) ) otherlv_4= '[' (otherlv_5= 'name' ( (lv_nameAlias_6_0= RULE_STRING ) ) ) (otherlv_7= 'isA' ( (otherlv_8= RULE_ID ) ) )? (otherlv_9= 'description' ( (lv_description_10_0= RULE_STRING ) ) )? otherlv_11= ']' )
            {
            // InternalRsl.g:2053:2: (otherlv_0= 'actor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleActorType ) ) otherlv_4= '[' (otherlv_5= 'name' ( (lv_nameAlias_6_0= RULE_STRING ) ) ) (otherlv_7= 'isA' ( (otherlv_8= RULE_ID ) ) )? (otherlv_9= 'description' ( (lv_description_10_0= RULE_STRING ) ) )? otherlv_11= ']' )
            // InternalRsl.g:2054:3: otherlv_0= 'actor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleActorType ) ) otherlv_4= '[' (otherlv_5= 'name' ( (lv_nameAlias_6_0= RULE_STRING ) ) ) (otherlv_7= 'isA' ( (otherlv_8= RULE_ID ) ) )? (otherlv_9= 'description' ( (lv_description_10_0= RULE_STRING ) ) )? otherlv_11= ']'
            {
            otherlv_0=(Token)match(input,59,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getActorAccess().getActorKeyword_0());
            		
            // InternalRsl.g:2058:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalRsl.g:2059:4: (lv_name_1_0= RULE_ID )
            {
            // InternalRsl.g:2059:4: (lv_name_1_0= RULE_ID )
            // InternalRsl.g:2060:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_14); 

            					newLeafNode(lv_name_1_0, grammarAccess.getActorAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getActorRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,29,FOLLOW_50); 

            			newLeafNode(otherlv_2, grammarAccess.getActorAccess().getColonKeyword_2());
            		
            // InternalRsl.g:2080:3: ( (lv_type_3_0= ruleActorType ) )
            // InternalRsl.g:2081:4: (lv_type_3_0= ruleActorType )
            {
            // InternalRsl.g:2081:4: (lv_type_3_0= ruleActorType )
            // InternalRsl.g:2082:5: lv_type_3_0= ruleActorType
            {

            					newCompositeNode(grammarAccess.getActorAccess().getTypeActorTypeEnumRuleCall_3_0());
            				
            pushFollow(FOLLOW_16);
            lv_type_3_0=ruleActorType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getActorRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_3_0,
            						"org.rslingo.rsl.Rsl.ActorType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,30,FOLLOW_17); 

            			newLeafNode(otherlv_4, grammarAccess.getActorAccess().getLeftSquareBracketKeyword_4());
            		
            // InternalRsl.g:2103:3: (otherlv_5= 'name' ( (lv_nameAlias_6_0= RULE_STRING ) ) )
            // InternalRsl.g:2104:4: otherlv_5= 'name' ( (lv_nameAlias_6_0= RULE_STRING ) )
            {
            otherlv_5=(Token)match(input,31,FOLLOW_18); 

            				newLeafNode(otherlv_5, grammarAccess.getActorAccess().getNameKeyword_5_0());
            			
            // InternalRsl.g:2108:4: ( (lv_nameAlias_6_0= RULE_STRING ) )
            // InternalRsl.g:2109:5: (lv_nameAlias_6_0= RULE_STRING )
            {
            // InternalRsl.g:2109:5: (lv_nameAlias_6_0= RULE_STRING )
            // InternalRsl.g:2110:6: lv_nameAlias_6_0= RULE_STRING
            {
            lv_nameAlias_6_0=(Token)match(input,RULE_STRING,FOLLOW_51); 

            						newLeafNode(lv_nameAlias_6_0, grammarAccess.getActorAccess().getNameAliasSTRINGTerminalRuleCall_5_1_0());
            					

            						if (current==null) {
            							current = createModelElement(grammarAccess.getActorRule());
            						}
            						setWithLastConsumed(
            							current,
            							"nameAlias",
            							lv_nameAlias_6_0,
            							"org.eclipse.xtext.common.Terminals.STRING");
            					

            }


            }


            }

            // InternalRsl.g:2127:3: (otherlv_7= 'isA' ( (otherlv_8= RULE_ID ) ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==39) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalRsl.g:2128:4: otherlv_7= 'isA' ( (otherlv_8= RULE_ID ) )
                    {
                    otherlv_7=(Token)match(input,39,FOLLOW_5); 

                    				newLeafNode(otherlv_7, grammarAccess.getActorAccess().getIsAKeyword_6_0());
                    			
                    // InternalRsl.g:2132:4: ( (otherlv_8= RULE_ID ) )
                    // InternalRsl.g:2133:5: (otherlv_8= RULE_ID )
                    {
                    // InternalRsl.g:2133:5: (otherlv_8= RULE_ID )
                    // InternalRsl.g:2134:6: otherlv_8= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getActorRule());
                    						}
                    					
                    otherlv_8=(Token)match(input,RULE_ID,FOLLOW_23); 

                    						newLeafNode(otherlv_8, grammarAccess.getActorAccess().getSuperActorCrossReference_6_1_0());
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalRsl.g:2146:3: (otherlv_9= 'description' ( (lv_description_10_0= RULE_STRING ) ) )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==35) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalRsl.g:2147:4: otherlv_9= 'description' ( (lv_description_10_0= RULE_STRING ) )
                    {
                    otherlv_9=(Token)match(input,35,FOLLOW_18); 

                    				newLeafNode(otherlv_9, grammarAccess.getActorAccess().getDescriptionKeyword_7_0());
                    			
                    // InternalRsl.g:2151:4: ( (lv_description_10_0= RULE_STRING ) )
                    // InternalRsl.g:2152:5: (lv_description_10_0= RULE_STRING )
                    {
                    // InternalRsl.g:2152:5: (lv_description_10_0= RULE_STRING )
                    // InternalRsl.g:2153:6: lv_description_10_0= RULE_STRING
                    {
                    lv_description_10_0=(Token)match(input,RULE_STRING,FOLLOW_24); 

                    						newLeafNode(lv_description_10_0, grammarAccess.getActorAccess().getDescriptionSTRINGTerminalRuleCall_7_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getActorRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"description",
                    							lv_description_10_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_11=(Token)match(input,36,FOLLOW_2); 

            			newLeafNode(otherlv_11, grammarAccess.getActorAccess().getRightSquareBracketKeyword_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleActor"


    // $ANTLR start "entryRuleRequirement"
    // InternalRsl.g:2178:1: entryRuleRequirement returns [EObject current=null] : iv_ruleRequirement= ruleRequirement EOF ;
    public final EObject entryRuleRequirement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRequirement = null;


        try {
            // InternalRsl.g:2178:52: (iv_ruleRequirement= ruleRequirement EOF )
            // InternalRsl.g:2179:2: iv_ruleRequirement= ruleRequirement EOF
            {
             newCompositeNode(grammarAccess.getRequirementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRequirement=ruleRequirement();

            state._fsp--;

             current =iv_ruleRequirement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRequirement"


    // $ANTLR start "ruleRequirement"
    // InternalRsl.g:2185:1: ruleRequirement returns [EObject current=null] : this_SystemRequirement_0= ruleSystemRequirement ;
    public final EObject ruleRequirement() throws RecognitionException {
        EObject current = null;

        EObject this_SystemRequirement_0 = null;



        	enterRule();

        try {
            // InternalRsl.g:2191:2: (this_SystemRequirement_0= ruleSystemRequirement )
            // InternalRsl.g:2192:2: this_SystemRequirement_0= ruleSystemRequirement
            {

            		newCompositeNode(grammarAccess.getRequirementAccess().getSystemRequirementParserRuleCall());
            	
            pushFollow(FOLLOW_2);
            this_SystemRequirement_0=ruleSystemRequirement();

            state._fsp--;


            		current = this_SystemRequirement_0;
            		afterParserOrEnumRuleCall();
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRequirement"


    // $ANTLR start "entryRuleSystemRequirement"
    // InternalRsl.g:2203:1: entryRuleSystemRequirement returns [EObject current=null] : iv_ruleSystemRequirement= ruleSystemRequirement EOF ;
    public final EObject entryRuleSystemRequirement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSystemRequirement = null;


        try {
            // InternalRsl.g:2203:58: (iv_ruleSystemRequirement= ruleSystemRequirement EOF )
            // InternalRsl.g:2204:2: iv_ruleSystemRequirement= ruleSystemRequirement EOF
            {
             newCompositeNode(grammarAccess.getSystemRequirementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSystemRequirement=ruleSystemRequirement();

            state._fsp--;

             current =iv_ruleSystemRequirement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSystemRequirement"


    // $ANTLR start "ruleSystemRequirement"
    // InternalRsl.g:2210:1: ruleSystemRequirement returns [EObject current=null] : this_UseCase_0= ruleUseCase ;
    public final EObject ruleSystemRequirement() throws RecognitionException {
        EObject current = null;

        EObject this_UseCase_0 = null;



        	enterRule();

        try {
            // InternalRsl.g:2216:2: (this_UseCase_0= ruleUseCase )
            // InternalRsl.g:2217:2: this_UseCase_0= ruleUseCase
            {

            		newCompositeNode(grammarAccess.getSystemRequirementAccess().getUseCaseParserRuleCall());
            	
            pushFollow(FOLLOW_2);
            this_UseCase_0=ruleUseCase();

            state._fsp--;


            		current = this_UseCase_0;
            		afterParserOrEnumRuleCall();
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSystemRequirement"


    // $ANTLR start "entryRuleRequirementRelation"
    // InternalRsl.g:2228:1: entryRuleRequirementRelation returns [EObject current=null] : iv_ruleRequirementRelation= ruleRequirementRelation EOF ;
    public final EObject entryRuleRequirementRelation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRequirementRelation = null;


        try {
            // InternalRsl.g:2228:60: (iv_ruleRequirementRelation= ruleRequirementRelation EOF )
            // InternalRsl.g:2229:2: iv_ruleRequirementRelation= ruleRequirementRelation EOF
            {
             newCompositeNode(grammarAccess.getRequirementRelationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRequirementRelation=ruleRequirementRelation();

            state._fsp--;

             current =iv_ruleRequirementRelation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRequirementRelation"


    // $ANTLR start "ruleRequirementRelation"
    // InternalRsl.g:2235:1: ruleRequirementRelation returns [EObject current=null] : (otherlv_0= 'requirementRelation' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleRequirementRelationType ) ) otherlv_4= '[' otherlv_5= 'source' ( (otherlv_6= RULE_ID ) ) otherlv_7= 'target' ( (otherlv_8= RULE_ID ) ) (otherlv_9= 'description' ( (lv_description_10_0= RULE_STRING ) ) )? otherlv_11= ']' ) ;
    public final EObject ruleRequirementRelation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token lv_description_10_0=null;
        Token otherlv_11=null;
        Enumerator lv_type_3_0 = null;



        	enterRule();

        try {
            // InternalRsl.g:2241:2: ( (otherlv_0= 'requirementRelation' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleRequirementRelationType ) ) otherlv_4= '[' otherlv_5= 'source' ( (otherlv_6= RULE_ID ) ) otherlv_7= 'target' ( (otherlv_8= RULE_ID ) ) (otherlv_9= 'description' ( (lv_description_10_0= RULE_STRING ) ) )? otherlv_11= ']' ) )
            // InternalRsl.g:2242:2: (otherlv_0= 'requirementRelation' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleRequirementRelationType ) ) otherlv_4= '[' otherlv_5= 'source' ( (otherlv_6= RULE_ID ) ) otherlv_7= 'target' ( (otherlv_8= RULE_ID ) ) (otherlv_9= 'description' ( (lv_description_10_0= RULE_STRING ) ) )? otherlv_11= ']' )
            {
            // InternalRsl.g:2242:2: (otherlv_0= 'requirementRelation' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleRequirementRelationType ) ) otherlv_4= '[' otherlv_5= 'source' ( (otherlv_6= RULE_ID ) ) otherlv_7= 'target' ( (otherlv_8= RULE_ID ) ) (otherlv_9= 'description' ( (lv_description_10_0= RULE_STRING ) ) )? otherlv_11= ']' )
            // InternalRsl.g:2243:3: otherlv_0= 'requirementRelation' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleRequirementRelationType ) ) otherlv_4= '[' otherlv_5= 'source' ( (otherlv_6= RULE_ID ) ) otherlv_7= 'target' ( (otherlv_8= RULE_ID ) ) (otherlv_9= 'description' ( (lv_description_10_0= RULE_STRING ) ) )? otherlv_11= ']'
            {
            otherlv_0=(Token)match(input,60,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getRequirementRelationAccess().getRequirementRelationKeyword_0());
            		
            // InternalRsl.g:2247:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalRsl.g:2248:4: (lv_name_1_0= RULE_ID )
            {
            // InternalRsl.g:2248:4: (lv_name_1_0= RULE_ID )
            // InternalRsl.g:2249:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_14); 

            					newLeafNode(lv_name_1_0, grammarAccess.getRequirementRelationAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRequirementRelationRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,29,FOLLOW_52); 

            			newLeafNode(otherlv_2, grammarAccess.getRequirementRelationAccess().getColonKeyword_2());
            		
            // InternalRsl.g:2269:3: ( (lv_type_3_0= ruleRequirementRelationType ) )
            // InternalRsl.g:2270:4: (lv_type_3_0= ruleRequirementRelationType )
            {
            // InternalRsl.g:2270:4: (lv_type_3_0= ruleRequirementRelationType )
            // InternalRsl.g:2271:5: lv_type_3_0= ruleRequirementRelationType
            {

            					newCompositeNode(grammarAccess.getRequirementRelationAccess().getTypeRequirementRelationTypeEnumRuleCall_3_0());
            				
            pushFollow(FOLLOW_16);
            lv_type_3_0=ruleRequirementRelationType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRequirementRelationRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_3_0,
            						"org.rslingo.rsl.Rsl.RequirementRelationType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,30,FOLLOW_53); 

            			newLeafNode(otherlv_4, grammarAccess.getRequirementRelationAccess().getLeftSquareBracketKeyword_4());
            		
            otherlv_5=(Token)match(input,61,FOLLOW_5); 

            			newLeafNode(otherlv_5, grammarAccess.getRequirementRelationAccess().getSourceKeyword_5());
            		
            // InternalRsl.g:2296:3: ( (otherlv_6= RULE_ID ) )
            // InternalRsl.g:2297:4: (otherlv_6= RULE_ID )
            {
            // InternalRsl.g:2297:4: (otherlv_6= RULE_ID )
            // InternalRsl.g:2298:5: otherlv_6= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRequirementRelationRule());
            					}
            				
            otherlv_6=(Token)match(input,RULE_ID,FOLLOW_54); 

            					newLeafNode(otherlv_6, grammarAccess.getRequirementRelationAccess().getSourceRequirementCrossReference_6_0());
            				

            }


            }

            otherlv_7=(Token)match(input,62,FOLLOW_5); 

            			newLeafNode(otherlv_7, grammarAccess.getRequirementRelationAccess().getTargetKeyword_7());
            		
            // InternalRsl.g:2313:3: ( (otherlv_8= RULE_ID ) )
            // InternalRsl.g:2314:4: (otherlv_8= RULE_ID )
            {
            // InternalRsl.g:2314:4: (otherlv_8= RULE_ID )
            // InternalRsl.g:2315:5: otherlv_8= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRequirementRelationRule());
            					}
            				
            otherlv_8=(Token)match(input,RULE_ID,FOLLOW_23); 

            					newLeafNode(otherlv_8, grammarAccess.getRequirementRelationAccess().getTargetRequirementCrossReference_8_0());
            				

            }


            }

            // InternalRsl.g:2326:3: (otherlv_9= 'description' ( (lv_description_10_0= RULE_STRING ) ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==35) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalRsl.g:2327:4: otherlv_9= 'description' ( (lv_description_10_0= RULE_STRING ) )
                    {
                    otherlv_9=(Token)match(input,35,FOLLOW_18); 

                    				newLeafNode(otherlv_9, grammarAccess.getRequirementRelationAccess().getDescriptionKeyword_9_0());
                    			
                    // InternalRsl.g:2331:4: ( (lv_description_10_0= RULE_STRING ) )
                    // InternalRsl.g:2332:5: (lv_description_10_0= RULE_STRING )
                    {
                    // InternalRsl.g:2332:5: (lv_description_10_0= RULE_STRING )
                    // InternalRsl.g:2333:6: lv_description_10_0= RULE_STRING
                    {
                    lv_description_10_0=(Token)match(input,RULE_STRING,FOLLOW_24); 

                    						newLeafNode(lv_description_10_0, grammarAccess.getRequirementRelationAccess().getDescriptionSTRINGTerminalRuleCall_9_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getRequirementRelationRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"description",
                    							lv_description_10_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_11=(Token)match(input,36,FOLLOW_2); 

            			newLeafNode(otherlv_11, grammarAccess.getRequirementRelationAccess().getRightSquareBracketKeyword_10());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRequirementRelation"


    // $ANTLR start "entryRuleUseCase"
    // InternalRsl.g:2358:1: entryRuleUseCase returns [EObject current=null] : iv_ruleUseCase= ruleUseCase EOF ;
    public final EObject entryRuleUseCase() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUseCase = null;


        try {
            // InternalRsl.g:2358:48: (iv_ruleUseCase= ruleUseCase EOF )
            // InternalRsl.g:2359:2: iv_ruleUseCase= ruleUseCase EOF
            {
             newCompositeNode(grammarAccess.getUseCaseRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUseCase=ruleUseCase();

            state._fsp--;

             current =iv_ruleUseCase; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUseCase"


    // $ANTLR start "ruleUseCase"
    // InternalRsl.g:2365:1: ruleUseCase returns [EObject current=null] : (otherlv_0= 'useCase' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleUseCaseType ) ) otherlv_4= '[' (otherlv_5= 'name' ( (lv_nameAlias_6_0= RULE_STRING ) ) ) (otherlv_7= 'actorInitiates' ( (otherlv_8= RULE_ID ) ) ) (otherlv_9= 'actorParticipates' ( (lv_actorParticipates_10_0= ruleRefActor ) ) )? (otherlv_11= 'dataEntityView' ( (otherlv_12= RULE_ID ) ) )? (otherlv_13= 'precondition' ( (lv_precondition_14_0= RULE_STRING ) ) )? (otherlv_15= 'postcondition' ( (lv_postcondition_16_0= RULE_STRING ) ) )? ( (lv_actions_17_0= ruleUCActions ) )? ( (lv_extensionPoints_18_0= ruleUCExtensionPoints ) )? ( (lv_includes_19_0= ruleUCIncludes ) )? ( (lv_extends_20_0= ruleUCExtends ) )* (otherlv_21= 'priority' ( (lv_priority_22_0= rulePriorityType ) ) )? (otherlv_23= 'description' ( (lv_description_24_0= RULE_STRING ) ) )? ( (lv_scenarios_25_0= ruleScenario ) )* otherlv_26= ']' ) ;
    public final EObject ruleUseCase() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token lv_nameAlias_6_0=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token lv_precondition_14_0=null;
        Token otherlv_15=null;
        Token lv_postcondition_16_0=null;
        Token otherlv_21=null;
        Token otherlv_23=null;
        Token lv_description_24_0=null;
        Token otherlv_26=null;
        Enumerator lv_type_3_0 = null;

        EObject lv_actorParticipates_10_0 = null;

        EObject lv_actions_17_0 = null;

        EObject lv_extensionPoints_18_0 = null;

        EObject lv_includes_19_0 = null;

        EObject lv_extends_20_0 = null;

        Enumerator lv_priority_22_0 = null;

        EObject lv_scenarios_25_0 = null;



        	enterRule();

        try {
            // InternalRsl.g:2371:2: ( (otherlv_0= 'useCase' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleUseCaseType ) ) otherlv_4= '[' (otherlv_5= 'name' ( (lv_nameAlias_6_0= RULE_STRING ) ) ) (otherlv_7= 'actorInitiates' ( (otherlv_8= RULE_ID ) ) ) (otherlv_9= 'actorParticipates' ( (lv_actorParticipates_10_0= ruleRefActor ) ) )? (otherlv_11= 'dataEntityView' ( (otherlv_12= RULE_ID ) ) )? (otherlv_13= 'precondition' ( (lv_precondition_14_0= RULE_STRING ) ) )? (otherlv_15= 'postcondition' ( (lv_postcondition_16_0= RULE_STRING ) ) )? ( (lv_actions_17_0= ruleUCActions ) )? ( (lv_extensionPoints_18_0= ruleUCExtensionPoints ) )? ( (lv_includes_19_0= ruleUCIncludes ) )? ( (lv_extends_20_0= ruleUCExtends ) )* (otherlv_21= 'priority' ( (lv_priority_22_0= rulePriorityType ) ) )? (otherlv_23= 'description' ( (lv_description_24_0= RULE_STRING ) ) )? ( (lv_scenarios_25_0= ruleScenario ) )* otherlv_26= ']' ) )
            // InternalRsl.g:2372:2: (otherlv_0= 'useCase' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleUseCaseType ) ) otherlv_4= '[' (otherlv_5= 'name' ( (lv_nameAlias_6_0= RULE_STRING ) ) ) (otherlv_7= 'actorInitiates' ( (otherlv_8= RULE_ID ) ) ) (otherlv_9= 'actorParticipates' ( (lv_actorParticipates_10_0= ruleRefActor ) ) )? (otherlv_11= 'dataEntityView' ( (otherlv_12= RULE_ID ) ) )? (otherlv_13= 'precondition' ( (lv_precondition_14_0= RULE_STRING ) ) )? (otherlv_15= 'postcondition' ( (lv_postcondition_16_0= RULE_STRING ) ) )? ( (lv_actions_17_0= ruleUCActions ) )? ( (lv_extensionPoints_18_0= ruleUCExtensionPoints ) )? ( (lv_includes_19_0= ruleUCIncludes ) )? ( (lv_extends_20_0= ruleUCExtends ) )* (otherlv_21= 'priority' ( (lv_priority_22_0= rulePriorityType ) ) )? (otherlv_23= 'description' ( (lv_description_24_0= RULE_STRING ) ) )? ( (lv_scenarios_25_0= ruleScenario ) )* otherlv_26= ']' )
            {
            // InternalRsl.g:2372:2: (otherlv_0= 'useCase' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleUseCaseType ) ) otherlv_4= '[' (otherlv_5= 'name' ( (lv_nameAlias_6_0= RULE_STRING ) ) ) (otherlv_7= 'actorInitiates' ( (otherlv_8= RULE_ID ) ) ) (otherlv_9= 'actorParticipates' ( (lv_actorParticipates_10_0= ruleRefActor ) ) )? (otherlv_11= 'dataEntityView' ( (otherlv_12= RULE_ID ) ) )? (otherlv_13= 'precondition' ( (lv_precondition_14_0= RULE_STRING ) ) )? (otherlv_15= 'postcondition' ( (lv_postcondition_16_0= RULE_STRING ) ) )? ( (lv_actions_17_0= ruleUCActions ) )? ( (lv_extensionPoints_18_0= ruleUCExtensionPoints ) )? ( (lv_includes_19_0= ruleUCIncludes ) )? ( (lv_extends_20_0= ruleUCExtends ) )* (otherlv_21= 'priority' ( (lv_priority_22_0= rulePriorityType ) ) )? (otherlv_23= 'description' ( (lv_description_24_0= RULE_STRING ) ) )? ( (lv_scenarios_25_0= ruleScenario ) )* otherlv_26= ']' )
            // InternalRsl.g:2373:3: otherlv_0= 'useCase' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleUseCaseType ) ) otherlv_4= '[' (otherlv_5= 'name' ( (lv_nameAlias_6_0= RULE_STRING ) ) ) (otherlv_7= 'actorInitiates' ( (otherlv_8= RULE_ID ) ) ) (otherlv_9= 'actorParticipates' ( (lv_actorParticipates_10_0= ruleRefActor ) ) )? (otherlv_11= 'dataEntityView' ( (otherlv_12= RULE_ID ) ) )? (otherlv_13= 'precondition' ( (lv_precondition_14_0= RULE_STRING ) ) )? (otherlv_15= 'postcondition' ( (lv_postcondition_16_0= RULE_STRING ) ) )? ( (lv_actions_17_0= ruleUCActions ) )? ( (lv_extensionPoints_18_0= ruleUCExtensionPoints ) )? ( (lv_includes_19_0= ruleUCIncludes ) )? ( (lv_extends_20_0= ruleUCExtends ) )* (otherlv_21= 'priority' ( (lv_priority_22_0= rulePriorityType ) ) )? (otherlv_23= 'description' ( (lv_description_24_0= RULE_STRING ) ) )? ( (lv_scenarios_25_0= ruleScenario ) )* otherlv_26= ']'
            {
            otherlv_0=(Token)match(input,63,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getUseCaseAccess().getUseCaseKeyword_0());
            		
            // InternalRsl.g:2377:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalRsl.g:2378:4: (lv_name_1_0= RULE_ID )
            {
            // InternalRsl.g:2378:4: (lv_name_1_0= RULE_ID )
            // InternalRsl.g:2379:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_14); 

            					newLeafNode(lv_name_1_0, grammarAccess.getUseCaseAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getUseCaseRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,29,FOLLOW_55); 

            			newLeafNode(otherlv_2, grammarAccess.getUseCaseAccess().getColonKeyword_2());
            		
            // InternalRsl.g:2399:3: ( (lv_type_3_0= ruleUseCaseType ) )
            // InternalRsl.g:2400:4: (lv_type_3_0= ruleUseCaseType )
            {
            // InternalRsl.g:2400:4: (lv_type_3_0= ruleUseCaseType )
            // InternalRsl.g:2401:5: lv_type_3_0= ruleUseCaseType
            {

            					newCompositeNode(grammarAccess.getUseCaseAccess().getTypeUseCaseTypeEnumRuleCall_3_0());
            				
            pushFollow(FOLLOW_16);
            lv_type_3_0=ruleUseCaseType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getUseCaseRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_3_0,
            						"org.rslingo.rsl.Rsl.UseCaseType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,30,FOLLOW_17); 

            			newLeafNode(otherlv_4, grammarAccess.getUseCaseAccess().getLeftSquareBracketKeyword_4());
            		
            // InternalRsl.g:2422:3: (otherlv_5= 'name' ( (lv_nameAlias_6_0= RULE_STRING ) ) )
            // InternalRsl.g:2423:4: otherlv_5= 'name' ( (lv_nameAlias_6_0= RULE_STRING ) )
            {
            otherlv_5=(Token)match(input,31,FOLLOW_18); 

            				newLeafNode(otherlv_5, grammarAccess.getUseCaseAccess().getNameKeyword_5_0());
            			
            // InternalRsl.g:2427:4: ( (lv_nameAlias_6_0= RULE_STRING ) )
            // InternalRsl.g:2428:5: (lv_nameAlias_6_0= RULE_STRING )
            {
            // InternalRsl.g:2428:5: (lv_nameAlias_6_0= RULE_STRING )
            // InternalRsl.g:2429:6: lv_nameAlias_6_0= RULE_STRING
            {
            lv_nameAlias_6_0=(Token)match(input,RULE_STRING,FOLLOW_56); 

            						newLeafNode(lv_nameAlias_6_0, grammarAccess.getUseCaseAccess().getNameAliasSTRINGTerminalRuleCall_5_1_0());
            					

            						if (current==null) {
            							current = createModelElement(grammarAccess.getUseCaseRule());
            						}
            						setWithLastConsumed(
            							current,
            							"nameAlias",
            							lv_nameAlias_6_0,
            							"org.eclipse.xtext.common.Terminals.STRING");
            					

            }


            }


            }

            // InternalRsl.g:2446:3: (otherlv_7= 'actorInitiates' ( (otherlv_8= RULE_ID ) ) )
            // InternalRsl.g:2447:4: otherlv_7= 'actorInitiates' ( (otherlv_8= RULE_ID ) )
            {
            otherlv_7=(Token)match(input,64,FOLLOW_5); 

            				newLeafNode(otherlv_7, grammarAccess.getUseCaseAccess().getActorInitiatesKeyword_6_0());
            			
            // InternalRsl.g:2451:4: ( (otherlv_8= RULE_ID ) )
            // InternalRsl.g:2452:5: (otherlv_8= RULE_ID )
            {
            // InternalRsl.g:2452:5: (otherlv_8= RULE_ID )
            // InternalRsl.g:2453:6: otherlv_8= RULE_ID
            {

            						if (current==null) {
            							current = createModelElement(grammarAccess.getUseCaseRule());
            						}
            					
            otherlv_8=(Token)match(input,RULE_ID,FOLLOW_57); 

            						newLeafNode(otherlv_8, grammarAccess.getUseCaseAccess().getActorInitiatesActorCrossReference_6_1_0());
            					

            }


            }


            }

            // InternalRsl.g:2465:3: (otherlv_9= 'actorParticipates' ( (lv_actorParticipates_10_0= ruleRefActor ) ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==65) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalRsl.g:2466:4: otherlv_9= 'actorParticipates' ( (lv_actorParticipates_10_0= ruleRefActor ) )
                    {
                    otherlv_9=(Token)match(input,65,FOLLOW_5); 

                    				newLeafNode(otherlv_9, grammarAccess.getUseCaseAccess().getActorParticipatesKeyword_7_0());
                    			
                    // InternalRsl.g:2470:4: ( (lv_actorParticipates_10_0= ruleRefActor ) )
                    // InternalRsl.g:2471:5: (lv_actorParticipates_10_0= ruleRefActor )
                    {
                    // InternalRsl.g:2471:5: (lv_actorParticipates_10_0= ruleRefActor )
                    // InternalRsl.g:2472:6: lv_actorParticipates_10_0= ruleRefActor
                    {

                    						newCompositeNode(grammarAccess.getUseCaseAccess().getActorParticipatesRefActorParserRuleCall_7_1_0());
                    					
                    pushFollow(FOLLOW_58);
                    lv_actorParticipates_10_0=ruleRefActor();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getUseCaseRule());
                    						}
                    						add(
                    							current,
                    							"actorParticipates",
                    							lv_actorParticipates_10_0,
                    							"org.rslingo.rsl.Rsl.RefActor");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalRsl.g:2490:3: (otherlv_11= 'dataEntityView' ( (otherlv_12= RULE_ID ) ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==55) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalRsl.g:2491:4: otherlv_11= 'dataEntityView' ( (otherlv_12= RULE_ID ) )
                    {
                    otherlv_11=(Token)match(input,55,FOLLOW_5); 

                    				newLeafNode(otherlv_11, grammarAccess.getUseCaseAccess().getDataEntityViewKeyword_8_0());
                    			
                    // InternalRsl.g:2495:4: ( (otherlv_12= RULE_ID ) )
                    // InternalRsl.g:2496:5: (otherlv_12= RULE_ID )
                    {
                    // InternalRsl.g:2496:5: (otherlv_12= RULE_ID )
                    // InternalRsl.g:2497:6: otherlv_12= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getUseCaseRule());
                    						}
                    					
                    otherlv_12=(Token)match(input,RULE_ID,FOLLOW_59); 

                    						newLeafNode(otherlv_12, grammarAccess.getUseCaseAccess().getDEntityViewDataEntityViewCrossReference_8_1_0());
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalRsl.g:2509:3: (otherlv_13= 'precondition' ( (lv_precondition_14_0= RULE_STRING ) ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==66) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalRsl.g:2510:4: otherlv_13= 'precondition' ( (lv_precondition_14_0= RULE_STRING ) )
                    {
                    otherlv_13=(Token)match(input,66,FOLLOW_18); 

                    				newLeafNode(otherlv_13, grammarAccess.getUseCaseAccess().getPreconditionKeyword_9_0());
                    			
                    // InternalRsl.g:2514:4: ( (lv_precondition_14_0= RULE_STRING ) )
                    // InternalRsl.g:2515:5: (lv_precondition_14_0= RULE_STRING )
                    {
                    // InternalRsl.g:2515:5: (lv_precondition_14_0= RULE_STRING )
                    // InternalRsl.g:2516:6: lv_precondition_14_0= RULE_STRING
                    {
                    lv_precondition_14_0=(Token)match(input,RULE_STRING,FOLLOW_60); 

                    						newLeafNode(lv_precondition_14_0, grammarAccess.getUseCaseAccess().getPreconditionSTRINGTerminalRuleCall_9_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getUseCaseRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"precondition",
                    							lv_precondition_14_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalRsl.g:2533:3: (otherlv_15= 'postcondition' ( (lv_postcondition_16_0= RULE_STRING ) ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==67) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalRsl.g:2534:4: otherlv_15= 'postcondition' ( (lv_postcondition_16_0= RULE_STRING ) )
                    {
                    otherlv_15=(Token)match(input,67,FOLLOW_18); 

                    				newLeafNode(otherlv_15, grammarAccess.getUseCaseAccess().getPostconditionKeyword_10_0());
                    			
                    // InternalRsl.g:2538:4: ( (lv_postcondition_16_0= RULE_STRING ) )
                    // InternalRsl.g:2539:5: (lv_postcondition_16_0= RULE_STRING )
                    {
                    // InternalRsl.g:2539:5: (lv_postcondition_16_0= RULE_STRING )
                    // InternalRsl.g:2540:6: lv_postcondition_16_0= RULE_STRING
                    {
                    lv_postcondition_16_0=(Token)match(input,RULE_STRING,FOLLOW_61); 

                    						newLeafNode(lv_postcondition_16_0, grammarAccess.getUseCaseAccess().getPostconditionSTRINGTerminalRuleCall_10_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getUseCaseRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"postcondition",
                    							lv_postcondition_16_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalRsl.g:2557:3: ( (lv_actions_17_0= ruleUCActions ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==69) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalRsl.g:2558:4: (lv_actions_17_0= ruleUCActions )
                    {
                    // InternalRsl.g:2558:4: (lv_actions_17_0= ruleUCActions )
                    // InternalRsl.g:2559:5: lv_actions_17_0= ruleUCActions
                    {

                    					newCompositeNode(grammarAccess.getUseCaseAccess().getActionsUCActionsParserRuleCall_11_0());
                    				
                    pushFollow(FOLLOW_62);
                    lv_actions_17_0=ruleUCActions();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getUseCaseRule());
                    					}
                    					set(
                    						current,
                    						"actions",
                    						lv_actions_17_0,
                    						"org.rslingo.rsl.Rsl.UCActions");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalRsl.g:2576:3: ( (lv_extensionPoints_18_0= ruleUCExtensionPoints ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==73) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalRsl.g:2577:4: (lv_extensionPoints_18_0= ruleUCExtensionPoints )
                    {
                    // InternalRsl.g:2577:4: (lv_extensionPoints_18_0= ruleUCExtensionPoints )
                    // InternalRsl.g:2578:5: lv_extensionPoints_18_0= ruleUCExtensionPoints
                    {

                    					newCompositeNode(grammarAccess.getUseCaseAccess().getExtensionPointsUCExtensionPointsParserRuleCall_12_0());
                    				
                    pushFollow(FOLLOW_63);
                    lv_extensionPoints_18_0=ruleUCExtensionPoints();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getUseCaseRule());
                    					}
                    					set(
                    						current,
                    						"extensionPoints",
                    						lv_extensionPoints_18_0,
                    						"org.rslingo.rsl.Rsl.UCExtensionPoints");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalRsl.g:2595:3: ( (lv_includes_19_0= ruleUCIncludes ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==70) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalRsl.g:2596:4: (lv_includes_19_0= ruleUCIncludes )
                    {
                    // InternalRsl.g:2596:4: (lv_includes_19_0= ruleUCIncludes )
                    // InternalRsl.g:2597:5: lv_includes_19_0= ruleUCIncludes
                    {

                    					newCompositeNode(grammarAccess.getUseCaseAccess().getIncludesUCIncludesParserRuleCall_13_0());
                    				
                    pushFollow(FOLLOW_64);
                    lv_includes_19_0=ruleUCIncludes();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getUseCaseRule());
                    					}
                    					set(
                    						current,
                    						"includes",
                    						lv_includes_19_0,
                    						"org.rslingo.rsl.Rsl.UCIncludes");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalRsl.g:2614:3: ( (lv_extends_20_0= ruleUCExtends ) )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==71) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // InternalRsl.g:2615:4: (lv_extends_20_0= ruleUCExtends )
            	    {
            	    // InternalRsl.g:2615:4: (lv_extends_20_0= ruleUCExtends )
            	    // InternalRsl.g:2616:5: lv_extends_20_0= ruleUCExtends
            	    {

            	    					newCompositeNode(grammarAccess.getUseCaseAccess().getExtendsUCExtendsParserRuleCall_14_0());
            	    				
            	    pushFollow(FOLLOW_64);
            	    lv_extends_20_0=ruleUCExtends();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getUseCaseRule());
            	    					}
            	    					add(
            	    						current,
            	    						"extends",
            	    						lv_extends_20_0,
            	    						"org.rslingo.rsl.Rsl.UCExtends");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop49;
                }
            } while (true);

            // InternalRsl.g:2633:3: (otherlv_21= 'priority' ( (lv_priority_22_0= rulePriorityType ) ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==68) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalRsl.g:2634:4: otherlv_21= 'priority' ( (lv_priority_22_0= rulePriorityType ) )
                    {
                    otherlv_21=(Token)match(input,68,FOLLOW_65); 

                    				newLeafNode(otherlv_21, grammarAccess.getUseCaseAccess().getPriorityKeyword_15_0());
                    			
                    // InternalRsl.g:2638:4: ( (lv_priority_22_0= rulePriorityType ) )
                    // InternalRsl.g:2639:5: (lv_priority_22_0= rulePriorityType )
                    {
                    // InternalRsl.g:2639:5: (lv_priority_22_0= rulePriorityType )
                    // InternalRsl.g:2640:6: lv_priority_22_0= rulePriorityType
                    {

                    						newCompositeNode(grammarAccess.getUseCaseAccess().getPriorityPriorityTypeEnumRuleCall_15_1_0());
                    					
                    pushFollow(FOLLOW_66);
                    lv_priority_22_0=rulePriorityType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getUseCaseRule());
                    						}
                    						set(
                    							current,
                    							"priority",
                    							lv_priority_22_0,
                    							"org.rslingo.rsl.Rsl.PriorityType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalRsl.g:2658:3: (otherlv_23= 'description' ( (lv_description_24_0= RULE_STRING ) ) )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==35) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // InternalRsl.g:2659:4: otherlv_23= 'description' ( (lv_description_24_0= RULE_STRING ) )
                    {
                    otherlv_23=(Token)match(input,35,FOLLOW_18); 

                    				newLeafNode(otherlv_23, grammarAccess.getUseCaseAccess().getDescriptionKeyword_16_0());
                    			
                    // InternalRsl.g:2663:4: ( (lv_description_24_0= RULE_STRING ) )
                    // InternalRsl.g:2664:5: (lv_description_24_0= RULE_STRING )
                    {
                    // InternalRsl.g:2664:5: (lv_description_24_0= RULE_STRING )
                    // InternalRsl.g:2665:6: lv_description_24_0= RULE_STRING
                    {
                    lv_description_24_0=(Token)match(input,RULE_STRING,FOLLOW_67); 

                    						newLeafNode(lv_description_24_0, grammarAccess.getUseCaseAccess().getDescriptionSTRINGTerminalRuleCall_16_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getUseCaseRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"description",
                    							lv_description_24_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalRsl.g:2682:3: ( (lv_scenarios_25_0= ruleScenario ) )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==74) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // InternalRsl.g:2683:4: (lv_scenarios_25_0= ruleScenario )
            	    {
            	    // InternalRsl.g:2683:4: (lv_scenarios_25_0= ruleScenario )
            	    // InternalRsl.g:2684:5: lv_scenarios_25_0= ruleScenario
            	    {

            	    					newCompositeNode(grammarAccess.getUseCaseAccess().getScenariosScenarioParserRuleCall_17_0());
            	    				
            	    pushFollow(FOLLOW_67);
            	    lv_scenarios_25_0=ruleScenario();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getUseCaseRule());
            	    					}
            	    					add(
            	    						current,
            	    						"scenarios",
            	    						lv_scenarios_25_0,
            	    						"org.rslingo.rsl.Rsl.Scenario");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop52;
                }
            } while (true);

            otherlv_26=(Token)match(input,36,FOLLOW_2); 

            			newLeafNode(otherlv_26, grammarAccess.getUseCaseAccess().getRightSquareBracketKeyword_18());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUseCase"


    // $ANTLR start "entryRuleRefActor"
    // InternalRsl.g:2709:1: entryRuleRefActor returns [EObject current=null] : iv_ruleRefActor= ruleRefActor EOF ;
    public final EObject entryRuleRefActor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefActor = null;


        try {
            // InternalRsl.g:2709:49: (iv_ruleRefActor= ruleRefActor EOF )
            // InternalRsl.g:2710:2: iv_ruleRefActor= ruleRefActor EOF
            {
             newCompositeNode(grammarAccess.getRefActorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRefActor=ruleRefActor();

            state._fsp--;

             current =iv_ruleRefActor; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRefActor"


    // $ANTLR start "ruleRefActor"
    // InternalRsl.g:2716:1: ruleRefActor returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= ',' ( (otherlv_2= RULE_ID ) ) )* ) ;
    public final EObject ruleRefActor() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalRsl.g:2722:2: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= ',' ( (otherlv_2= RULE_ID ) ) )* ) )
            // InternalRsl.g:2723:2: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= ',' ( (otherlv_2= RULE_ID ) ) )* )
            {
            // InternalRsl.g:2723:2: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= ',' ( (otherlv_2= RULE_ID ) ) )* )
            // InternalRsl.g:2724:3: ( (otherlv_0= RULE_ID ) ) (otherlv_1= ',' ( (otherlv_2= RULE_ID ) ) )*
            {
            // InternalRsl.g:2724:3: ( (otherlv_0= RULE_ID ) )
            // InternalRsl.g:2725:4: (otherlv_0= RULE_ID )
            {
            // InternalRsl.g:2725:4: (otherlv_0= RULE_ID )
            // InternalRsl.g:2726:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRefActorRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_25); 

            					newLeafNode(otherlv_0, grammarAccess.getRefActorAccess().getRefsActorCrossReference_0_0());
            				

            }


            }

            // InternalRsl.g:2737:3: (otherlv_1= ',' ( (otherlv_2= RULE_ID ) ) )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==37) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // InternalRsl.g:2738:4: otherlv_1= ',' ( (otherlv_2= RULE_ID ) )
            	    {
            	    otherlv_1=(Token)match(input,37,FOLLOW_5); 

            	    				newLeafNode(otherlv_1, grammarAccess.getRefActorAccess().getCommaKeyword_1_0());
            	    			
            	    // InternalRsl.g:2742:4: ( (otherlv_2= RULE_ID ) )
            	    // InternalRsl.g:2743:5: (otherlv_2= RULE_ID )
            	    {
            	    // InternalRsl.g:2743:5: (otherlv_2= RULE_ID )
            	    // InternalRsl.g:2744:6: otherlv_2= RULE_ID
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getRefActorRule());
            	    						}
            	    					
            	    otherlv_2=(Token)match(input,RULE_ID,FOLLOW_25); 

            	    						newLeafNode(otherlv_2, grammarAccess.getRefActorAccess().getRefsActorCrossReference_1_1_0());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop53;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRefActor"


    // $ANTLR start "entryRuleUCActions"
    // InternalRsl.g:2760:1: entryRuleUCActions returns [EObject current=null] : iv_ruleUCActions= ruleUCActions EOF ;
    public final EObject entryRuleUCActions() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUCActions = null;


        try {
            // InternalRsl.g:2760:50: (iv_ruleUCActions= ruleUCActions EOF )
            // InternalRsl.g:2761:2: iv_ruleUCActions= ruleUCActions EOF
            {
             newCompositeNode(grammarAccess.getUCActionsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUCActions=ruleUCActions();

            state._fsp--;

             current =iv_ruleUCActions; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUCActions"


    // $ANTLR start "ruleUCActions"
    // InternalRsl.g:2767:1: ruleUCActions returns [EObject current=null] : (otherlv_0= 'actions' ( (lv_actions_1_0= ruleUCAction ) ) (otherlv_2= ',' ( (lv_actions_3_0= ruleUCAction ) ) )* ) ;
    public final EObject ruleUCActions() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_actions_1_0 = null;

        EObject lv_actions_3_0 = null;



        	enterRule();

        try {
            // InternalRsl.g:2773:2: ( (otherlv_0= 'actions' ( (lv_actions_1_0= ruleUCAction ) ) (otherlv_2= ',' ( (lv_actions_3_0= ruleUCAction ) ) )* ) )
            // InternalRsl.g:2774:2: (otherlv_0= 'actions' ( (lv_actions_1_0= ruleUCAction ) ) (otherlv_2= ',' ( (lv_actions_3_0= ruleUCAction ) ) )* )
            {
            // InternalRsl.g:2774:2: (otherlv_0= 'actions' ( (lv_actions_1_0= ruleUCAction ) ) (otherlv_2= ',' ( (lv_actions_3_0= ruleUCAction ) ) )* )
            // InternalRsl.g:2775:3: otherlv_0= 'actions' ( (lv_actions_1_0= ruleUCAction ) ) (otherlv_2= ',' ( (lv_actions_3_0= ruleUCAction ) ) )*
            {
            otherlv_0=(Token)match(input,69,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getUCActionsAccess().getActionsKeyword_0());
            		
            // InternalRsl.g:2779:3: ( (lv_actions_1_0= ruleUCAction ) )
            // InternalRsl.g:2780:4: (lv_actions_1_0= ruleUCAction )
            {
            // InternalRsl.g:2780:4: (lv_actions_1_0= ruleUCAction )
            // InternalRsl.g:2781:5: lv_actions_1_0= ruleUCAction
            {

            					newCompositeNode(grammarAccess.getUCActionsAccess().getActionsUCActionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_25);
            lv_actions_1_0=ruleUCAction();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getUCActionsRule());
            					}
            					add(
            						current,
            						"actions",
            						lv_actions_1_0,
            						"org.rslingo.rsl.Rsl.UCAction");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRsl.g:2798:3: (otherlv_2= ',' ( (lv_actions_3_0= ruleUCAction ) ) )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==37) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // InternalRsl.g:2799:4: otherlv_2= ',' ( (lv_actions_3_0= ruleUCAction ) )
            	    {
            	    otherlv_2=(Token)match(input,37,FOLLOW_5); 

            	    				newLeafNode(otherlv_2, grammarAccess.getUCActionsAccess().getCommaKeyword_2_0());
            	    			
            	    // InternalRsl.g:2803:4: ( (lv_actions_3_0= ruleUCAction ) )
            	    // InternalRsl.g:2804:5: (lv_actions_3_0= ruleUCAction )
            	    {
            	    // InternalRsl.g:2804:5: (lv_actions_3_0= ruleUCAction )
            	    // InternalRsl.g:2805:6: lv_actions_3_0= ruleUCAction
            	    {

            	    						newCompositeNode(grammarAccess.getUCActionsAccess().getActionsUCActionParserRuleCall_2_1_0());
            	    					
            	    pushFollow(FOLLOW_25);
            	    lv_actions_3_0=ruleUCAction();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getUCActionsRule());
            	    						}
            	    						add(
            	    							current,
            	    							"actions",
            	    							lv_actions_3_0,
            	    							"org.rslingo.rsl.Rsl.UCAction");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop54;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUCActions"


    // $ANTLR start "entryRuleUCAction"
    // InternalRsl.g:2827:1: entryRuleUCAction returns [EObject current=null] : iv_ruleUCAction= ruleUCAction EOF ;
    public final EObject entryRuleUCAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUCAction = null;


        try {
            // InternalRsl.g:2827:49: (iv_ruleUCAction= ruleUCAction EOF )
            // InternalRsl.g:2828:2: iv_ruleUCAction= ruleUCAction EOF
            {
             newCompositeNode(grammarAccess.getUCActionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUCAction=ruleUCAction();

            state._fsp--;

             current =iv_ruleUCAction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUCAction"


    // $ANTLR start "ruleUCAction"
    // InternalRsl.g:2834:1: ruleUCAction returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '[' otherlv_2= 'description' ( (lv_description_3_0= RULE_STRING ) ) otherlv_4= ']' )? ) ;
    public final EObject ruleUCAction() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_description_3_0=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalRsl.g:2840:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '[' otherlv_2= 'description' ( (lv_description_3_0= RULE_STRING ) ) otherlv_4= ']' )? ) )
            // InternalRsl.g:2841:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '[' otherlv_2= 'description' ( (lv_description_3_0= RULE_STRING ) ) otherlv_4= ']' )? )
            {
            // InternalRsl.g:2841:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '[' otherlv_2= 'description' ( (lv_description_3_0= RULE_STRING ) ) otherlv_4= ']' )? )
            // InternalRsl.g:2842:3: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '[' otherlv_2= 'description' ( (lv_description_3_0= RULE_STRING ) ) otherlv_4= ']' )?
            {
            // InternalRsl.g:2842:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalRsl.g:2843:4: (lv_name_0_0= RULE_ID )
            {
            // InternalRsl.g:2843:4: (lv_name_0_0= RULE_ID )
            // InternalRsl.g:2844:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_48); 

            					newLeafNode(lv_name_0_0, grammarAccess.getUCActionAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getUCActionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalRsl.g:2860:3: (otherlv_1= '[' otherlv_2= 'description' ( (lv_description_3_0= RULE_STRING ) ) otherlv_4= ']' )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==30) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // InternalRsl.g:2861:4: otherlv_1= '[' otherlv_2= 'description' ( (lv_description_3_0= RULE_STRING ) ) otherlv_4= ']'
                    {
                    otherlv_1=(Token)match(input,30,FOLLOW_68); 

                    				newLeafNode(otherlv_1, grammarAccess.getUCActionAccess().getLeftSquareBracketKeyword_1_0());
                    			
                    otherlv_2=(Token)match(input,35,FOLLOW_18); 

                    				newLeafNode(otherlv_2, grammarAccess.getUCActionAccess().getDescriptionKeyword_1_1());
                    			
                    // InternalRsl.g:2869:4: ( (lv_description_3_0= RULE_STRING ) )
                    // InternalRsl.g:2870:5: (lv_description_3_0= RULE_STRING )
                    {
                    // InternalRsl.g:2870:5: (lv_description_3_0= RULE_STRING )
                    // InternalRsl.g:2871:6: lv_description_3_0= RULE_STRING
                    {
                    lv_description_3_0=(Token)match(input,RULE_STRING,FOLLOW_24); 

                    						newLeafNode(lv_description_3_0, grammarAccess.getUCActionAccess().getDescriptionSTRINGTerminalRuleCall_1_2_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getUCActionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"description",
                    							lv_description_3_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,36,FOLLOW_2); 

                    				newLeafNode(otherlv_4, grammarAccess.getUCActionAccess().getRightSquareBracketKeyword_1_3());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUCAction"


    // $ANTLR start "entryRuleUCIncludes"
    // InternalRsl.g:2896:1: entryRuleUCIncludes returns [EObject current=null] : iv_ruleUCIncludes= ruleUCIncludes EOF ;
    public final EObject entryRuleUCIncludes() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUCIncludes = null;


        try {
            // InternalRsl.g:2896:51: (iv_ruleUCIncludes= ruleUCIncludes EOF )
            // InternalRsl.g:2897:2: iv_ruleUCIncludes= ruleUCIncludes EOF
            {
             newCompositeNode(grammarAccess.getUCIncludesRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUCIncludes=ruleUCIncludes();

            state._fsp--;

             current =iv_ruleUCIncludes; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUCIncludes"


    // $ANTLR start "ruleUCIncludes"
    // InternalRsl.g:2903:1: ruleUCIncludes returns [EObject current=null] : (otherlv_0= 'includes' ( (lv_includes_1_0= ruleRefUC ) ) ) ;
    public final EObject ruleUCIncludes() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_includes_1_0 = null;



        	enterRule();

        try {
            // InternalRsl.g:2909:2: ( (otherlv_0= 'includes' ( (lv_includes_1_0= ruleRefUC ) ) ) )
            // InternalRsl.g:2910:2: (otherlv_0= 'includes' ( (lv_includes_1_0= ruleRefUC ) ) )
            {
            // InternalRsl.g:2910:2: (otherlv_0= 'includes' ( (lv_includes_1_0= ruleRefUC ) ) )
            // InternalRsl.g:2911:3: otherlv_0= 'includes' ( (lv_includes_1_0= ruleRefUC ) )
            {
            otherlv_0=(Token)match(input,70,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getUCIncludesAccess().getIncludesKeyword_0());
            		
            // InternalRsl.g:2915:3: ( (lv_includes_1_0= ruleRefUC ) )
            // InternalRsl.g:2916:4: (lv_includes_1_0= ruleRefUC )
            {
            // InternalRsl.g:2916:4: (lv_includes_1_0= ruleRefUC )
            // InternalRsl.g:2917:5: lv_includes_1_0= ruleRefUC
            {

            					newCompositeNode(grammarAccess.getUCIncludesAccess().getIncludesRefUCParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_includes_1_0=ruleRefUC();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getUCIncludesRule());
            					}
            					add(
            						current,
            						"includes",
            						lv_includes_1_0,
            						"org.rslingo.rsl.Rsl.RefUC");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUCIncludes"


    // $ANTLR start "entryRuleUCExtends"
    // InternalRsl.g:2938:1: entryRuleUCExtends returns [EObject current=null] : iv_ruleUCExtends= ruleUCExtends EOF ;
    public final EObject entryRuleUCExtends() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUCExtends = null;


        try {
            // InternalRsl.g:2938:50: (iv_ruleUCExtends= ruleUCExtends EOF )
            // InternalRsl.g:2939:2: iv_ruleUCExtends= ruleUCExtends EOF
            {
             newCompositeNode(grammarAccess.getUCExtendsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUCExtends=ruleUCExtends();

            state._fsp--;

             current =iv_ruleUCExtends; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUCExtends"


    // $ANTLR start "ruleUCExtends"
    // InternalRsl.g:2945:1: ruleUCExtends returns [EObject current=null] : (otherlv_0= 'extends' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'onExtensionPoint' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleUCExtends() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalRsl.g:2951:2: ( (otherlv_0= 'extends' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'onExtensionPoint' ( ( ruleQualifiedName ) ) ) )
            // InternalRsl.g:2952:2: (otherlv_0= 'extends' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'onExtensionPoint' ( ( ruleQualifiedName ) ) )
            {
            // InternalRsl.g:2952:2: (otherlv_0= 'extends' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'onExtensionPoint' ( ( ruleQualifiedName ) ) )
            // InternalRsl.g:2953:3: otherlv_0= 'extends' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'onExtensionPoint' ( ( ruleQualifiedName ) )
            {
            otherlv_0=(Token)match(input,71,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getUCExtendsAccess().getExtendsKeyword_0());
            		
            // InternalRsl.g:2957:3: ( (otherlv_1= RULE_ID ) )
            // InternalRsl.g:2958:4: (otherlv_1= RULE_ID )
            {
            // InternalRsl.g:2958:4: (otherlv_1= RULE_ID )
            // InternalRsl.g:2959:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getUCExtendsRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_69); 

            					newLeafNode(otherlv_1, grammarAccess.getUCExtendsAccess().getUsecaseUseCaseCrossReference_1_0());
            				

            }


            }

            otherlv_2=(Token)match(input,72,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getUCExtendsAccess().getOnExtensionPointKeyword_2());
            		
            // InternalRsl.g:2974:3: ( ( ruleQualifiedName ) )
            // InternalRsl.g:2975:4: ( ruleQualifiedName )
            {
            // InternalRsl.g:2975:4: ( ruleQualifiedName )
            // InternalRsl.g:2976:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getUCExtendsRule());
            					}
            				

            					newCompositeNode(grammarAccess.getUCExtendsAccess().getExtensionPointUCExtensionPointCrossReference_3_0());
            				
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUCExtends"


    // $ANTLR start "entryRuleUCExtensionPoints"
    // InternalRsl.g:2994:1: entryRuleUCExtensionPoints returns [EObject current=null] : iv_ruleUCExtensionPoints= ruleUCExtensionPoints EOF ;
    public final EObject entryRuleUCExtensionPoints() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUCExtensionPoints = null;


        try {
            // InternalRsl.g:2994:58: (iv_ruleUCExtensionPoints= ruleUCExtensionPoints EOF )
            // InternalRsl.g:2995:2: iv_ruleUCExtensionPoints= ruleUCExtensionPoints EOF
            {
             newCompositeNode(grammarAccess.getUCExtensionPointsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUCExtensionPoints=ruleUCExtensionPoints();

            state._fsp--;

             current =iv_ruleUCExtensionPoints; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUCExtensionPoints"


    // $ANTLR start "ruleUCExtensionPoints"
    // InternalRsl.g:3001:1: ruleUCExtensionPoints returns [EObject current=null] : (otherlv_0= 'extensionPoints' ( (lv_extensionPoints_1_0= ruleUCExtensionPoint ) ) (otherlv_2= ',' ( (lv_extensionPoints_3_0= ruleUCExtensionPoint ) ) )* ) ;
    public final EObject ruleUCExtensionPoints() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_extensionPoints_1_0 = null;

        EObject lv_extensionPoints_3_0 = null;



        	enterRule();

        try {
            // InternalRsl.g:3007:2: ( (otherlv_0= 'extensionPoints' ( (lv_extensionPoints_1_0= ruleUCExtensionPoint ) ) (otherlv_2= ',' ( (lv_extensionPoints_3_0= ruleUCExtensionPoint ) ) )* ) )
            // InternalRsl.g:3008:2: (otherlv_0= 'extensionPoints' ( (lv_extensionPoints_1_0= ruleUCExtensionPoint ) ) (otherlv_2= ',' ( (lv_extensionPoints_3_0= ruleUCExtensionPoint ) ) )* )
            {
            // InternalRsl.g:3008:2: (otherlv_0= 'extensionPoints' ( (lv_extensionPoints_1_0= ruleUCExtensionPoint ) ) (otherlv_2= ',' ( (lv_extensionPoints_3_0= ruleUCExtensionPoint ) ) )* )
            // InternalRsl.g:3009:3: otherlv_0= 'extensionPoints' ( (lv_extensionPoints_1_0= ruleUCExtensionPoint ) ) (otherlv_2= ',' ( (lv_extensionPoints_3_0= ruleUCExtensionPoint ) ) )*
            {
            otherlv_0=(Token)match(input,73,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getUCExtensionPointsAccess().getExtensionPointsKeyword_0());
            		
            // InternalRsl.g:3013:3: ( (lv_extensionPoints_1_0= ruleUCExtensionPoint ) )
            // InternalRsl.g:3014:4: (lv_extensionPoints_1_0= ruleUCExtensionPoint )
            {
            // InternalRsl.g:3014:4: (lv_extensionPoints_1_0= ruleUCExtensionPoint )
            // InternalRsl.g:3015:5: lv_extensionPoints_1_0= ruleUCExtensionPoint
            {

            					newCompositeNode(grammarAccess.getUCExtensionPointsAccess().getExtensionPointsUCExtensionPointParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_25);
            lv_extensionPoints_1_0=ruleUCExtensionPoint();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getUCExtensionPointsRule());
            					}
            					add(
            						current,
            						"extensionPoints",
            						lv_extensionPoints_1_0,
            						"org.rslingo.rsl.Rsl.UCExtensionPoint");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRsl.g:3032:3: (otherlv_2= ',' ( (lv_extensionPoints_3_0= ruleUCExtensionPoint ) ) )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==37) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // InternalRsl.g:3033:4: otherlv_2= ',' ( (lv_extensionPoints_3_0= ruleUCExtensionPoint ) )
            	    {
            	    otherlv_2=(Token)match(input,37,FOLLOW_5); 

            	    				newLeafNode(otherlv_2, grammarAccess.getUCExtensionPointsAccess().getCommaKeyword_2_0());
            	    			
            	    // InternalRsl.g:3037:4: ( (lv_extensionPoints_3_0= ruleUCExtensionPoint ) )
            	    // InternalRsl.g:3038:5: (lv_extensionPoints_3_0= ruleUCExtensionPoint )
            	    {
            	    // InternalRsl.g:3038:5: (lv_extensionPoints_3_0= ruleUCExtensionPoint )
            	    // InternalRsl.g:3039:6: lv_extensionPoints_3_0= ruleUCExtensionPoint
            	    {

            	    						newCompositeNode(grammarAccess.getUCExtensionPointsAccess().getExtensionPointsUCExtensionPointParserRuleCall_2_1_0());
            	    					
            	    pushFollow(FOLLOW_25);
            	    lv_extensionPoints_3_0=ruleUCExtensionPoint();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getUCExtensionPointsRule());
            	    						}
            	    						add(
            	    							current,
            	    							"extensionPoints",
            	    							lv_extensionPoints_3_0,
            	    							"org.rslingo.rsl.Rsl.UCExtensionPoint");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop56;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUCExtensionPoints"


    // $ANTLR start "entryRuleUCExtensionPoint"
    // InternalRsl.g:3061:1: entryRuleUCExtensionPoint returns [EObject current=null] : iv_ruleUCExtensionPoint= ruleUCExtensionPoint EOF ;
    public final EObject entryRuleUCExtensionPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUCExtensionPoint = null;


        try {
            // InternalRsl.g:3061:57: (iv_ruleUCExtensionPoint= ruleUCExtensionPoint EOF )
            // InternalRsl.g:3062:2: iv_ruleUCExtensionPoint= ruleUCExtensionPoint EOF
            {
             newCompositeNode(grammarAccess.getUCExtensionPointRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUCExtensionPoint=ruleUCExtensionPoint();

            state._fsp--;

             current =iv_ruleUCExtensionPoint; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUCExtensionPoint"


    // $ANTLR start "ruleUCExtensionPoint"
    // InternalRsl.g:3068:1: ruleUCExtensionPoint returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '[' otherlv_2= 'description' ( (lv_description_3_0= RULE_STRING ) ) otherlv_4= ']' )? ) ;
    public final EObject ruleUCExtensionPoint() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_description_3_0=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalRsl.g:3074:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '[' otherlv_2= 'description' ( (lv_description_3_0= RULE_STRING ) ) otherlv_4= ']' )? ) )
            // InternalRsl.g:3075:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '[' otherlv_2= 'description' ( (lv_description_3_0= RULE_STRING ) ) otherlv_4= ']' )? )
            {
            // InternalRsl.g:3075:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '[' otherlv_2= 'description' ( (lv_description_3_0= RULE_STRING ) ) otherlv_4= ']' )? )
            // InternalRsl.g:3076:3: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '[' otherlv_2= 'description' ( (lv_description_3_0= RULE_STRING ) ) otherlv_4= ']' )?
            {
            // InternalRsl.g:3076:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalRsl.g:3077:4: (lv_name_0_0= RULE_ID )
            {
            // InternalRsl.g:3077:4: (lv_name_0_0= RULE_ID )
            // InternalRsl.g:3078:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_48); 

            					newLeafNode(lv_name_0_0, grammarAccess.getUCExtensionPointAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getUCExtensionPointRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalRsl.g:3094:3: (otherlv_1= '[' otherlv_2= 'description' ( (lv_description_3_0= RULE_STRING ) ) otherlv_4= ']' )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==30) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // InternalRsl.g:3095:4: otherlv_1= '[' otherlv_2= 'description' ( (lv_description_3_0= RULE_STRING ) ) otherlv_4= ']'
                    {
                    otherlv_1=(Token)match(input,30,FOLLOW_68); 

                    				newLeafNode(otherlv_1, grammarAccess.getUCExtensionPointAccess().getLeftSquareBracketKeyword_1_0());
                    			
                    otherlv_2=(Token)match(input,35,FOLLOW_18); 

                    				newLeafNode(otherlv_2, grammarAccess.getUCExtensionPointAccess().getDescriptionKeyword_1_1());
                    			
                    // InternalRsl.g:3103:4: ( (lv_description_3_0= RULE_STRING ) )
                    // InternalRsl.g:3104:5: (lv_description_3_0= RULE_STRING )
                    {
                    // InternalRsl.g:3104:5: (lv_description_3_0= RULE_STRING )
                    // InternalRsl.g:3105:6: lv_description_3_0= RULE_STRING
                    {
                    lv_description_3_0=(Token)match(input,RULE_STRING,FOLLOW_24); 

                    						newLeafNode(lv_description_3_0, grammarAccess.getUCExtensionPointAccess().getDescriptionSTRINGTerminalRuleCall_1_2_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getUCExtensionPointRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"description",
                    							lv_description_3_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,36,FOLLOW_2); 

                    				newLeafNode(otherlv_4, grammarAccess.getUCExtensionPointAccess().getRightSquareBracketKeyword_1_3());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUCExtensionPoint"


    // $ANTLR start "entryRuleRefUC"
    // InternalRsl.g:3130:1: entryRuleRefUC returns [EObject current=null] : iv_ruleRefUC= ruleRefUC EOF ;
    public final EObject entryRuleRefUC() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefUC = null;


        try {
            // InternalRsl.g:3130:46: (iv_ruleRefUC= ruleRefUC EOF )
            // InternalRsl.g:3131:2: iv_ruleRefUC= ruleRefUC EOF
            {
             newCompositeNode(grammarAccess.getRefUCRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRefUC=ruleRefUC();

            state._fsp--;

             current =iv_ruleRefUC; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRefUC"


    // $ANTLR start "ruleRefUC"
    // InternalRsl.g:3137:1: ruleRefUC returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= ',' ( (otherlv_2= RULE_ID ) ) )* ) ;
    public final EObject ruleRefUC() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalRsl.g:3143:2: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= ',' ( (otherlv_2= RULE_ID ) ) )* ) )
            // InternalRsl.g:3144:2: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= ',' ( (otherlv_2= RULE_ID ) ) )* )
            {
            // InternalRsl.g:3144:2: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= ',' ( (otherlv_2= RULE_ID ) ) )* )
            // InternalRsl.g:3145:3: ( (otherlv_0= RULE_ID ) ) (otherlv_1= ',' ( (otherlv_2= RULE_ID ) ) )*
            {
            // InternalRsl.g:3145:3: ( (otherlv_0= RULE_ID ) )
            // InternalRsl.g:3146:4: (otherlv_0= RULE_ID )
            {
            // InternalRsl.g:3146:4: (otherlv_0= RULE_ID )
            // InternalRsl.g:3147:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRefUCRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_25); 

            					newLeafNode(otherlv_0, grammarAccess.getRefUCAccess().getRefsUseCaseCrossReference_0_0());
            				

            }


            }

            // InternalRsl.g:3158:3: (otherlv_1= ',' ( (otherlv_2= RULE_ID ) ) )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==37) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // InternalRsl.g:3159:4: otherlv_1= ',' ( (otherlv_2= RULE_ID ) )
            	    {
            	    otherlv_1=(Token)match(input,37,FOLLOW_5); 

            	    				newLeafNode(otherlv_1, grammarAccess.getRefUCAccess().getCommaKeyword_1_0());
            	    			
            	    // InternalRsl.g:3163:4: ( (otherlv_2= RULE_ID ) )
            	    // InternalRsl.g:3164:5: (otherlv_2= RULE_ID )
            	    {
            	    // InternalRsl.g:3164:5: (otherlv_2= RULE_ID )
            	    // InternalRsl.g:3165:6: otherlv_2= RULE_ID
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getRefUCRule());
            	    						}
            	    					
            	    otherlv_2=(Token)match(input,RULE_ID,FOLLOW_25); 

            	    						newLeafNode(otherlv_2, grammarAccess.getRefUCAccess().getRefsUseCaseCrossReference_1_1_0());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop58;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRefUC"


    // $ANTLR start "entryRuleScenario"
    // InternalRsl.g:3181:1: entryRuleScenario returns [EObject current=null] : iv_ruleScenario= ruleScenario EOF ;
    public final EObject entryRuleScenario() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScenario = null;


        try {
            // InternalRsl.g:3181:49: (iv_ruleScenario= ruleScenario EOF )
            // InternalRsl.g:3182:2: iv_ruleScenario= ruleScenario EOF
            {
             newCompositeNode(grammarAccess.getScenarioRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleScenario=ruleScenario();

            state._fsp--;

             current =iv_ruleScenario; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleScenario"


    // $ANTLR start "ruleScenario"
    // InternalRsl.g:3188:1: ruleScenario returns [EObject current=null] : (otherlv_0= 'scenario' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleScenarioType ) ) otherlv_4= '[' (otherlv_5= 'name' ( (lv_nameAlias_6_0= RULE_STRING ) ) ) (otherlv_7= 'executionMode' ( ( (lv_mode_8_1= 'Sequential' | lv_mode_8_2= 'Parallel' ) ) ) )? (otherlv_9= 'description' ( (lv_description_10_0= RULE_STRING ) ) )? ( (lv_steps_11_0= ruleStep ) )* otherlv_12= ']' ) ;
    public final EObject ruleScenario() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token lv_nameAlias_6_0=null;
        Token otherlv_7=null;
        Token lv_mode_8_1=null;
        Token lv_mode_8_2=null;
        Token otherlv_9=null;
        Token lv_description_10_0=null;
        Token otherlv_12=null;
        Enumerator lv_type_3_0 = null;

        EObject lv_steps_11_0 = null;



        	enterRule();

        try {
            // InternalRsl.g:3194:2: ( (otherlv_0= 'scenario' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleScenarioType ) ) otherlv_4= '[' (otherlv_5= 'name' ( (lv_nameAlias_6_0= RULE_STRING ) ) ) (otherlv_7= 'executionMode' ( ( (lv_mode_8_1= 'Sequential' | lv_mode_8_2= 'Parallel' ) ) ) )? (otherlv_9= 'description' ( (lv_description_10_0= RULE_STRING ) ) )? ( (lv_steps_11_0= ruleStep ) )* otherlv_12= ']' ) )
            // InternalRsl.g:3195:2: (otherlv_0= 'scenario' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleScenarioType ) ) otherlv_4= '[' (otherlv_5= 'name' ( (lv_nameAlias_6_0= RULE_STRING ) ) ) (otherlv_7= 'executionMode' ( ( (lv_mode_8_1= 'Sequential' | lv_mode_8_2= 'Parallel' ) ) ) )? (otherlv_9= 'description' ( (lv_description_10_0= RULE_STRING ) ) )? ( (lv_steps_11_0= ruleStep ) )* otherlv_12= ']' )
            {
            // InternalRsl.g:3195:2: (otherlv_0= 'scenario' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleScenarioType ) ) otherlv_4= '[' (otherlv_5= 'name' ( (lv_nameAlias_6_0= RULE_STRING ) ) ) (otherlv_7= 'executionMode' ( ( (lv_mode_8_1= 'Sequential' | lv_mode_8_2= 'Parallel' ) ) ) )? (otherlv_9= 'description' ( (lv_description_10_0= RULE_STRING ) ) )? ( (lv_steps_11_0= ruleStep ) )* otherlv_12= ']' )
            // InternalRsl.g:3196:3: otherlv_0= 'scenario' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleScenarioType ) ) otherlv_4= '[' (otherlv_5= 'name' ( (lv_nameAlias_6_0= RULE_STRING ) ) ) (otherlv_7= 'executionMode' ( ( (lv_mode_8_1= 'Sequential' | lv_mode_8_2= 'Parallel' ) ) ) )? (otherlv_9= 'description' ( (lv_description_10_0= RULE_STRING ) ) )? ( (lv_steps_11_0= ruleStep ) )* otherlv_12= ']'
            {
            otherlv_0=(Token)match(input,74,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getScenarioAccess().getScenarioKeyword_0());
            		
            // InternalRsl.g:3200:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalRsl.g:3201:4: (lv_name_1_0= RULE_ID )
            {
            // InternalRsl.g:3201:4: (lv_name_1_0= RULE_ID )
            // InternalRsl.g:3202:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_14); 

            					newLeafNode(lv_name_1_0, grammarAccess.getScenarioAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getScenarioRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,29,FOLLOW_70); 

            			newLeafNode(otherlv_2, grammarAccess.getScenarioAccess().getColonKeyword_2());
            		
            // InternalRsl.g:3222:3: ( (lv_type_3_0= ruleScenarioType ) )
            // InternalRsl.g:3223:4: (lv_type_3_0= ruleScenarioType )
            {
            // InternalRsl.g:3223:4: (lv_type_3_0= ruleScenarioType )
            // InternalRsl.g:3224:5: lv_type_3_0= ruleScenarioType
            {

            					newCompositeNode(grammarAccess.getScenarioAccess().getTypeScenarioTypeEnumRuleCall_3_0());
            				
            pushFollow(FOLLOW_16);
            lv_type_3_0=ruleScenarioType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getScenarioRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_3_0,
            						"org.rslingo.rsl.Rsl.ScenarioType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,30,FOLLOW_17); 

            			newLeafNode(otherlv_4, grammarAccess.getScenarioAccess().getLeftSquareBracketKeyword_4());
            		
            // InternalRsl.g:3245:3: (otherlv_5= 'name' ( (lv_nameAlias_6_0= RULE_STRING ) ) )
            // InternalRsl.g:3246:4: otherlv_5= 'name' ( (lv_nameAlias_6_0= RULE_STRING ) )
            {
            otherlv_5=(Token)match(input,31,FOLLOW_18); 

            				newLeafNode(otherlv_5, grammarAccess.getScenarioAccess().getNameKeyword_5_0());
            			
            // InternalRsl.g:3250:4: ( (lv_nameAlias_6_0= RULE_STRING ) )
            // InternalRsl.g:3251:5: (lv_nameAlias_6_0= RULE_STRING )
            {
            // InternalRsl.g:3251:5: (lv_nameAlias_6_0= RULE_STRING )
            // InternalRsl.g:3252:6: lv_nameAlias_6_0= RULE_STRING
            {
            lv_nameAlias_6_0=(Token)match(input,RULE_STRING,FOLLOW_71); 

            						newLeafNode(lv_nameAlias_6_0, grammarAccess.getScenarioAccess().getNameAliasSTRINGTerminalRuleCall_5_1_0());
            					

            						if (current==null) {
            							current = createModelElement(grammarAccess.getScenarioRule());
            						}
            						setWithLastConsumed(
            							current,
            							"nameAlias",
            							lv_nameAlias_6_0,
            							"org.eclipse.xtext.common.Terminals.STRING");
            					

            }


            }


            }

            // InternalRsl.g:3269:3: (otherlv_7= 'executionMode' ( ( (lv_mode_8_1= 'Sequential' | lv_mode_8_2= 'Parallel' ) ) ) )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==75) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // InternalRsl.g:3270:4: otherlv_7= 'executionMode' ( ( (lv_mode_8_1= 'Sequential' | lv_mode_8_2= 'Parallel' ) ) )
                    {
                    otherlv_7=(Token)match(input,75,FOLLOW_72); 

                    				newLeafNode(otherlv_7, grammarAccess.getScenarioAccess().getExecutionModeKeyword_6_0());
                    			
                    // InternalRsl.g:3274:4: ( ( (lv_mode_8_1= 'Sequential' | lv_mode_8_2= 'Parallel' ) ) )
                    // InternalRsl.g:3275:5: ( (lv_mode_8_1= 'Sequential' | lv_mode_8_2= 'Parallel' ) )
                    {
                    // InternalRsl.g:3275:5: ( (lv_mode_8_1= 'Sequential' | lv_mode_8_2= 'Parallel' ) )
                    // InternalRsl.g:3276:6: (lv_mode_8_1= 'Sequential' | lv_mode_8_2= 'Parallel' )
                    {
                    // InternalRsl.g:3276:6: (lv_mode_8_1= 'Sequential' | lv_mode_8_2= 'Parallel' )
                    int alt59=2;
                    int LA59_0 = input.LA(1);

                    if ( (LA59_0==76) ) {
                        alt59=1;
                    }
                    else if ( (LA59_0==77) ) {
                        alt59=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 59, 0, input);

                        throw nvae;
                    }
                    switch (alt59) {
                        case 1 :
                            // InternalRsl.g:3277:7: lv_mode_8_1= 'Sequential'
                            {
                            lv_mode_8_1=(Token)match(input,76,FOLLOW_73); 

                            							newLeafNode(lv_mode_8_1, grammarAccess.getScenarioAccess().getModeSequentialKeyword_6_1_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getScenarioRule());
                            							}
                            							setWithLastConsumed(current, "mode", lv_mode_8_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalRsl.g:3288:7: lv_mode_8_2= 'Parallel'
                            {
                            lv_mode_8_2=(Token)match(input,77,FOLLOW_73); 

                            							newLeafNode(lv_mode_8_2, grammarAccess.getScenarioAccess().getModeParallelKeyword_6_1_0_1());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getScenarioRule());
                            							}
                            							setWithLastConsumed(current, "mode", lv_mode_8_2, null);
                            						

                            }
                            break;

                    }


                    }


                    }


                    }
                    break;

            }

            // InternalRsl.g:3302:3: (otherlv_9= 'description' ( (lv_description_10_0= RULE_STRING ) ) )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==35) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // InternalRsl.g:3303:4: otherlv_9= 'description' ( (lv_description_10_0= RULE_STRING ) )
                    {
                    otherlv_9=(Token)match(input,35,FOLLOW_18); 

                    				newLeafNode(otherlv_9, grammarAccess.getScenarioAccess().getDescriptionKeyword_7_0());
                    			
                    // InternalRsl.g:3307:4: ( (lv_description_10_0= RULE_STRING ) )
                    // InternalRsl.g:3308:5: (lv_description_10_0= RULE_STRING )
                    {
                    // InternalRsl.g:3308:5: (lv_description_10_0= RULE_STRING )
                    // InternalRsl.g:3309:6: lv_description_10_0= RULE_STRING
                    {
                    lv_description_10_0=(Token)match(input,RULE_STRING,FOLLOW_74); 

                    						newLeafNode(lv_description_10_0, grammarAccess.getScenarioAccess().getDescriptionSTRINGTerminalRuleCall_7_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getScenarioRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"description",
                    							lv_description_10_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalRsl.g:3326:3: ( (lv_steps_11_0= ruleStep ) )*
            loop62:
            do {
                int alt62=2;
                int LA62_0 = input.LA(1);

                if ( (LA62_0==78) ) {
                    alt62=1;
                }


                switch (alt62) {
            	case 1 :
            	    // InternalRsl.g:3327:4: (lv_steps_11_0= ruleStep )
            	    {
            	    // InternalRsl.g:3327:4: (lv_steps_11_0= ruleStep )
            	    // InternalRsl.g:3328:5: lv_steps_11_0= ruleStep
            	    {

            	    					newCompositeNode(grammarAccess.getScenarioAccess().getStepsStepParserRuleCall_8_0());
            	    				
            	    pushFollow(FOLLOW_74);
            	    lv_steps_11_0=ruleStep();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getScenarioRule());
            	    					}
            	    					add(
            	    						current,
            	    						"steps",
            	    						lv_steps_11_0,
            	    						"org.rslingo.rsl.Rsl.Step");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop62;
                }
            } while (true);

            otherlv_12=(Token)match(input,36,FOLLOW_2); 

            			newLeafNode(otherlv_12, grammarAccess.getScenarioAccess().getRightSquareBracketKeyword_9());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleScenario"


    // $ANTLR start "entryRuleStep"
    // InternalRsl.g:3353:1: entryRuleStep returns [EObject current=null] : iv_ruleStep= ruleStep EOF ;
    public final EObject entryRuleStep() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStep = null;


        try {
            // InternalRsl.g:3353:45: (iv_ruleStep= ruleStep EOF )
            // InternalRsl.g:3354:2: iv_ruleStep= ruleStep EOF
            {
             newCompositeNode(grammarAccess.getStepRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStep=ruleStep();

            state._fsp--;

             current =iv_ruleStep; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStep"


    // $ANTLR start "ruleStep"
    // InternalRsl.g:3360:1: ruleStep returns [EObject current=null] : (otherlv_0= 'step' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleStepOperationType ) ) (otherlv_4= ':' ( (lv_subType_5_0= ruleStepOperationSubType ) ) )? otherlv_6= '[' ( ( (lv_simpleStep_7_0= ruleSimpleStep ) ) | ( (lv_subSteps_8_0= ruleStep ) )+ | ( (lv_ifSteps_9_0= ruleIfStep ) )* ) otherlv_10= ']' ) ;
    public final EObject ruleStep() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_10=null;
        Enumerator lv_type_3_0 = null;

        Enumerator lv_subType_5_0 = null;

        EObject lv_simpleStep_7_0 = null;

        EObject lv_subSteps_8_0 = null;

        EObject lv_ifSteps_9_0 = null;



        	enterRule();

        try {
            // InternalRsl.g:3366:2: ( (otherlv_0= 'step' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleStepOperationType ) ) (otherlv_4= ':' ( (lv_subType_5_0= ruleStepOperationSubType ) ) )? otherlv_6= '[' ( ( (lv_simpleStep_7_0= ruleSimpleStep ) ) | ( (lv_subSteps_8_0= ruleStep ) )+ | ( (lv_ifSteps_9_0= ruleIfStep ) )* ) otherlv_10= ']' ) )
            // InternalRsl.g:3367:2: (otherlv_0= 'step' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleStepOperationType ) ) (otherlv_4= ':' ( (lv_subType_5_0= ruleStepOperationSubType ) ) )? otherlv_6= '[' ( ( (lv_simpleStep_7_0= ruleSimpleStep ) ) | ( (lv_subSteps_8_0= ruleStep ) )+ | ( (lv_ifSteps_9_0= ruleIfStep ) )* ) otherlv_10= ']' )
            {
            // InternalRsl.g:3367:2: (otherlv_0= 'step' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleStepOperationType ) ) (otherlv_4= ':' ( (lv_subType_5_0= ruleStepOperationSubType ) ) )? otherlv_6= '[' ( ( (lv_simpleStep_7_0= ruleSimpleStep ) ) | ( (lv_subSteps_8_0= ruleStep ) )+ | ( (lv_ifSteps_9_0= ruleIfStep ) )* ) otherlv_10= ']' )
            // InternalRsl.g:3368:3: otherlv_0= 'step' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleStepOperationType ) ) (otherlv_4= ':' ( (lv_subType_5_0= ruleStepOperationSubType ) ) )? otherlv_6= '[' ( ( (lv_simpleStep_7_0= ruleSimpleStep ) ) | ( (lv_subSteps_8_0= ruleStep ) )+ | ( (lv_ifSteps_9_0= ruleIfStep ) )* ) otherlv_10= ']'
            {
            otherlv_0=(Token)match(input,78,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getStepAccess().getStepKeyword_0());
            		
            // InternalRsl.g:3372:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalRsl.g:3373:4: (lv_name_1_0= RULE_ID )
            {
            // InternalRsl.g:3373:4: (lv_name_1_0= RULE_ID )
            // InternalRsl.g:3374:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_14); 

            					newLeafNode(lv_name_1_0, grammarAccess.getStepAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStepRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,29,FOLLOW_75); 

            			newLeafNode(otherlv_2, grammarAccess.getStepAccess().getColonKeyword_2());
            		
            // InternalRsl.g:3394:3: ( (lv_type_3_0= ruleStepOperationType ) )
            // InternalRsl.g:3395:4: (lv_type_3_0= ruleStepOperationType )
            {
            // InternalRsl.g:3395:4: (lv_type_3_0= ruleStepOperationType )
            // InternalRsl.g:3396:5: lv_type_3_0= ruleStepOperationType
            {

            					newCompositeNode(grammarAccess.getStepAccess().getTypeStepOperationTypeEnumRuleCall_3_0());
            				
            pushFollow(FOLLOW_27);
            lv_type_3_0=ruleStepOperationType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getStepRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_3_0,
            						"org.rslingo.rsl.Rsl.StepOperationType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRsl.g:3413:3: (otherlv_4= ':' ( (lv_subType_5_0= ruleStepOperationSubType ) ) )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==29) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // InternalRsl.g:3414:4: otherlv_4= ':' ( (lv_subType_5_0= ruleStepOperationSubType ) )
                    {
                    otherlv_4=(Token)match(input,29,FOLLOW_76); 

                    				newLeafNode(otherlv_4, grammarAccess.getStepAccess().getColonKeyword_4_0());
                    			
                    // InternalRsl.g:3418:4: ( (lv_subType_5_0= ruleStepOperationSubType ) )
                    // InternalRsl.g:3419:5: (lv_subType_5_0= ruleStepOperationSubType )
                    {
                    // InternalRsl.g:3419:5: (lv_subType_5_0= ruleStepOperationSubType )
                    // InternalRsl.g:3420:6: lv_subType_5_0= ruleStepOperationSubType
                    {

                    						newCompositeNode(grammarAccess.getStepAccess().getSubTypeStepOperationSubTypeEnumRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_16);
                    lv_subType_5_0=ruleStepOperationSubType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getStepRule());
                    						}
                    						set(
                    							current,
                    							"subType",
                    							lv_subType_5_0,
                    							"org.rslingo.rsl.Rsl.StepOperationSubType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,30,FOLLOW_77); 

            			newLeafNode(otherlv_6, grammarAccess.getStepAccess().getLeftSquareBracketKeyword_5());
            		
            // InternalRsl.g:3442:3: ( ( (lv_simpleStep_7_0= ruleSimpleStep ) ) | ( (lv_subSteps_8_0= ruleStep ) )+ | ( (lv_ifSteps_9_0= ruleIfStep ) )* )
            int alt66=3;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt66=1;
                }
                break;
            case 78:
                {
                alt66=2;
                }
                break;
            case 36:
            case 80:
                {
                alt66=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;
            }

            switch (alt66) {
                case 1 :
                    // InternalRsl.g:3443:4: ( (lv_simpleStep_7_0= ruleSimpleStep ) )
                    {
                    // InternalRsl.g:3443:4: ( (lv_simpleStep_7_0= ruleSimpleStep ) )
                    // InternalRsl.g:3444:5: (lv_simpleStep_7_0= ruleSimpleStep )
                    {
                    // InternalRsl.g:3444:5: (lv_simpleStep_7_0= ruleSimpleStep )
                    // InternalRsl.g:3445:6: lv_simpleStep_7_0= ruleSimpleStep
                    {

                    						newCompositeNode(grammarAccess.getStepAccess().getSimpleStepSimpleStepParserRuleCall_6_0_0());
                    					
                    pushFollow(FOLLOW_24);
                    lv_simpleStep_7_0=ruleSimpleStep();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getStepRule());
                    						}
                    						set(
                    							current,
                    							"simpleStep",
                    							lv_simpleStep_7_0,
                    							"org.rslingo.rsl.Rsl.SimpleStep");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalRsl.g:3463:4: ( (lv_subSteps_8_0= ruleStep ) )+
                    {
                    // InternalRsl.g:3463:4: ( (lv_subSteps_8_0= ruleStep ) )+
                    int cnt64=0;
                    loop64:
                    do {
                        int alt64=2;
                        int LA64_0 = input.LA(1);

                        if ( (LA64_0==78) ) {
                            alt64=1;
                        }


                        switch (alt64) {
                    	case 1 :
                    	    // InternalRsl.g:3464:5: (lv_subSteps_8_0= ruleStep )
                    	    {
                    	    // InternalRsl.g:3464:5: (lv_subSteps_8_0= ruleStep )
                    	    // InternalRsl.g:3465:6: lv_subSteps_8_0= ruleStep
                    	    {

                    	    						newCompositeNode(grammarAccess.getStepAccess().getSubStepsStepParserRuleCall_6_1_0());
                    	    					
                    	    pushFollow(FOLLOW_74);
                    	    lv_subSteps_8_0=ruleStep();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getStepRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"subSteps",
                    	    							lv_subSteps_8_0,
                    	    							"org.rslingo.rsl.Rsl.Step");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt64 >= 1 ) break loop64;
                                EarlyExitException eee =
                                    new EarlyExitException(64, input);
                                throw eee;
                        }
                        cnt64++;
                    } while (true);


                    }
                    break;
                case 3 :
                    // InternalRsl.g:3483:4: ( (lv_ifSteps_9_0= ruleIfStep ) )*
                    {
                    // InternalRsl.g:3483:4: ( (lv_ifSteps_9_0= ruleIfStep ) )*
                    loop65:
                    do {
                        int alt65=2;
                        int LA65_0 = input.LA(1);

                        if ( (LA65_0==80) ) {
                            alt65=1;
                        }


                        switch (alt65) {
                    	case 1 :
                    	    // InternalRsl.g:3484:5: (lv_ifSteps_9_0= ruleIfStep )
                    	    {
                    	    // InternalRsl.g:3484:5: (lv_ifSteps_9_0= ruleIfStep )
                    	    // InternalRsl.g:3485:6: lv_ifSteps_9_0= ruleIfStep
                    	    {

                    	    						newCompositeNode(grammarAccess.getStepAccess().getIfStepsIfStepParserRuleCall_6_2_0());
                    	    					
                    	    pushFollow(FOLLOW_78);
                    	    lv_ifSteps_9_0=ruleIfStep();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getStepRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"ifSteps",
                    	    							lv_ifSteps_9_0,
                    	    							"org.rslingo.rsl.Rsl.IfStep");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop65;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_10=(Token)match(input,36,FOLLOW_2); 

            			newLeafNode(otherlv_10, grammarAccess.getStepAccess().getRightSquareBracketKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStep"


    // $ANTLR start "entryRuleSimpleStep"
    // InternalRsl.g:3511:1: entryRuleSimpleStep returns [EObject current=null] : iv_ruleSimpleStep= ruleSimpleStep EOF ;
    public final EObject entryRuleSimpleStep() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleStep = null;


        try {
            // InternalRsl.g:3511:51: (iv_ruleSimpleStep= ruleSimpleStep EOF )
            // InternalRsl.g:3512:2: iv_ruleSimpleStep= ruleSimpleStep EOF
            {
             newCompositeNode(grammarAccess.getSimpleStepRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSimpleStep=ruleSimpleStep();

            state._fsp--;

             current =iv_ruleSimpleStep; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSimpleStep"


    // $ANTLR start "ruleSimpleStep"
    // InternalRsl.g:3518:1: ruleSimpleStep returns [EObject current=null] : ( ( (lv_nameAlias_0_0= RULE_STRING ) ) (otherlv_1= 'actor' ( (otherlv_2= RULE_ID ) ) )? (otherlv_3= 'description' ( (lv_description_4_0= RULE_STRING ) ) )? (otherlv_5= 'precondition' ( (lv_precondition_6_0= RULE_STRING ) ) )? (otherlv_7= 'postcondition' ( (lv_postcondition_8_0= RULE_STRING ) ) )? (otherlv_9= 'nextStep' ( (otherlv_10= RULE_ID ) ) )? ) ;
    public final EObject ruleSimpleStep() throws RecognitionException {
        EObject current = null;

        Token lv_nameAlias_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_description_4_0=null;
        Token otherlv_5=null;
        Token lv_precondition_6_0=null;
        Token otherlv_7=null;
        Token lv_postcondition_8_0=null;
        Token otherlv_9=null;
        Token otherlv_10=null;


        	enterRule();

        try {
            // InternalRsl.g:3524:2: ( ( ( (lv_nameAlias_0_0= RULE_STRING ) ) (otherlv_1= 'actor' ( (otherlv_2= RULE_ID ) ) )? (otherlv_3= 'description' ( (lv_description_4_0= RULE_STRING ) ) )? (otherlv_5= 'precondition' ( (lv_precondition_6_0= RULE_STRING ) ) )? (otherlv_7= 'postcondition' ( (lv_postcondition_8_0= RULE_STRING ) ) )? (otherlv_9= 'nextStep' ( (otherlv_10= RULE_ID ) ) )? ) )
            // InternalRsl.g:3525:2: ( ( (lv_nameAlias_0_0= RULE_STRING ) ) (otherlv_1= 'actor' ( (otherlv_2= RULE_ID ) ) )? (otherlv_3= 'description' ( (lv_description_4_0= RULE_STRING ) ) )? (otherlv_5= 'precondition' ( (lv_precondition_6_0= RULE_STRING ) ) )? (otherlv_7= 'postcondition' ( (lv_postcondition_8_0= RULE_STRING ) ) )? (otherlv_9= 'nextStep' ( (otherlv_10= RULE_ID ) ) )? )
            {
            // InternalRsl.g:3525:2: ( ( (lv_nameAlias_0_0= RULE_STRING ) ) (otherlv_1= 'actor' ( (otherlv_2= RULE_ID ) ) )? (otherlv_3= 'description' ( (lv_description_4_0= RULE_STRING ) ) )? (otherlv_5= 'precondition' ( (lv_precondition_6_0= RULE_STRING ) ) )? (otherlv_7= 'postcondition' ( (lv_postcondition_8_0= RULE_STRING ) ) )? (otherlv_9= 'nextStep' ( (otherlv_10= RULE_ID ) ) )? )
            // InternalRsl.g:3526:3: ( (lv_nameAlias_0_0= RULE_STRING ) ) (otherlv_1= 'actor' ( (otherlv_2= RULE_ID ) ) )? (otherlv_3= 'description' ( (lv_description_4_0= RULE_STRING ) ) )? (otherlv_5= 'precondition' ( (lv_precondition_6_0= RULE_STRING ) ) )? (otherlv_7= 'postcondition' ( (lv_postcondition_8_0= RULE_STRING ) ) )? (otherlv_9= 'nextStep' ( (otherlv_10= RULE_ID ) ) )?
            {
            // InternalRsl.g:3526:3: ( (lv_nameAlias_0_0= RULE_STRING ) )
            // InternalRsl.g:3527:4: (lv_nameAlias_0_0= RULE_STRING )
            {
            // InternalRsl.g:3527:4: (lv_nameAlias_0_0= RULE_STRING )
            // InternalRsl.g:3528:5: lv_nameAlias_0_0= RULE_STRING
            {
            lv_nameAlias_0_0=(Token)match(input,RULE_STRING,FOLLOW_79); 

            					newLeafNode(lv_nameAlias_0_0, grammarAccess.getSimpleStepAccess().getNameAliasSTRINGTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSimpleStepRule());
            					}
            					setWithLastConsumed(
            						current,
            						"nameAlias",
            						lv_nameAlias_0_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalRsl.g:3544:3: (otherlv_1= 'actor' ( (otherlv_2= RULE_ID ) ) )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==59) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // InternalRsl.g:3545:4: otherlv_1= 'actor' ( (otherlv_2= RULE_ID ) )
                    {
                    otherlv_1=(Token)match(input,59,FOLLOW_5); 

                    				newLeafNode(otherlv_1, grammarAccess.getSimpleStepAccess().getActorKeyword_1_0());
                    			
                    // InternalRsl.g:3549:4: ( (otherlv_2= RULE_ID ) )
                    // InternalRsl.g:3550:5: (otherlv_2= RULE_ID )
                    {
                    // InternalRsl.g:3550:5: (otherlv_2= RULE_ID )
                    // InternalRsl.g:3551:6: otherlv_2= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getSimpleStepRule());
                    						}
                    					
                    otherlv_2=(Token)match(input,RULE_ID,FOLLOW_80); 

                    						newLeafNode(otherlv_2, grammarAccess.getSimpleStepAccess().getActorActorCrossReference_1_1_0());
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalRsl.g:3563:3: (otherlv_3= 'description' ( (lv_description_4_0= RULE_STRING ) ) )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==35) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // InternalRsl.g:3564:4: otherlv_3= 'description' ( (lv_description_4_0= RULE_STRING ) )
                    {
                    otherlv_3=(Token)match(input,35,FOLLOW_18); 

                    				newLeafNode(otherlv_3, grammarAccess.getSimpleStepAccess().getDescriptionKeyword_2_0());
                    			
                    // InternalRsl.g:3568:4: ( (lv_description_4_0= RULE_STRING ) )
                    // InternalRsl.g:3569:5: (lv_description_4_0= RULE_STRING )
                    {
                    // InternalRsl.g:3569:5: (lv_description_4_0= RULE_STRING )
                    // InternalRsl.g:3570:6: lv_description_4_0= RULE_STRING
                    {
                    lv_description_4_0=(Token)match(input,RULE_STRING,FOLLOW_81); 

                    						newLeafNode(lv_description_4_0, grammarAccess.getSimpleStepAccess().getDescriptionSTRINGTerminalRuleCall_2_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getSimpleStepRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"description",
                    							lv_description_4_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalRsl.g:3587:3: (otherlv_5= 'precondition' ( (lv_precondition_6_0= RULE_STRING ) ) )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==66) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // InternalRsl.g:3588:4: otherlv_5= 'precondition' ( (lv_precondition_6_0= RULE_STRING ) )
                    {
                    otherlv_5=(Token)match(input,66,FOLLOW_18); 

                    				newLeafNode(otherlv_5, grammarAccess.getSimpleStepAccess().getPreconditionKeyword_3_0());
                    			
                    // InternalRsl.g:3592:4: ( (lv_precondition_6_0= RULE_STRING ) )
                    // InternalRsl.g:3593:5: (lv_precondition_6_0= RULE_STRING )
                    {
                    // InternalRsl.g:3593:5: (lv_precondition_6_0= RULE_STRING )
                    // InternalRsl.g:3594:6: lv_precondition_6_0= RULE_STRING
                    {
                    lv_precondition_6_0=(Token)match(input,RULE_STRING,FOLLOW_82); 

                    						newLeafNode(lv_precondition_6_0, grammarAccess.getSimpleStepAccess().getPreconditionSTRINGTerminalRuleCall_3_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getSimpleStepRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"precondition",
                    							lv_precondition_6_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalRsl.g:3611:3: (otherlv_7= 'postcondition' ( (lv_postcondition_8_0= RULE_STRING ) ) )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==67) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // InternalRsl.g:3612:4: otherlv_7= 'postcondition' ( (lv_postcondition_8_0= RULE_STRING ) )
                    {
                    otherlv_7=(Token)match(input,67,FOLLOW_18); 

                    				newLeafNode(otherlv_7, grammarAccess.getSimpleStepAccess().getPostconditionKeyword_4_0());
                    			
                    // InternalRsl.g:3616:4: ( (lv_postcondition_8_0= RULE_STRING ) )
                    // InternalRsl.g:3617:5: (lv_postcondition_8_0= RULE_STRING )
                    {
                    // InternalRsl.g:3617:5: (lv_postcondition_8_0= RULE_STRING )
                    // InternalRsl.g:3618:6: lv_postcondition_8_0= RULE_STRING
                    {
                    lv_postcondition_8_0=(Token)match(input,RULE_STRING,FOLLOW_83); 

                    						newLeafNode(lv_postcondition_8_0, grammarAccess.getSimpleStepAccess().getPostconditionSTRINGTerminalRuleCall_4_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getSimpleStepRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"postcondition",
                    							lv_postcondition_8_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalRsl.g:3635:3: (otherlv_9= 'nextStep' ( (otherlv_10= RULE_ID ) ) )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==79) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // InternalRsl.g:3636:4: otherlv_9= 'nextStep' ( (otherlv_10= RULE_ID ) )
                    {
                    otherlv_9=(Token)match(input,79,FOLLOW_5); 

                    				newLeafNode(otherlv_9, grammarAccess.getSimpleStepAccess().getNextStepKeyword_5_0());
                    			
                    // InternalRsl.g:3640:4: ( (otherlv_10= RULE_ID ) )
                    // InternalRsl.g:3641:5: (otherlv_10= RULE_ID )
                    {
                    // InternalRsl.g:3641:5: (otherlv_10= RULE_ID )
                    // InternalRsl.g:3642:6: otherlv_10= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getSimpleStepRule());
                    						}
                    					
                    otherlv_10=(Token)match(input,RULE_ID,FOLLOW_2); 

                    						newLeafNode(otherlv_10, grammarAccess.getSimpleStepAccess().getNextStepCrossReference_5_1_0());
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSimpleStep"


    // $ANTLR start "entryRuleIfStep"
    // InternalRsl.g:3658:1: entryRuleIfStep returns [EObject current=null] : iv_ruleIfStep= ruleIfStep EOF ;
    public final EObject entryRuleIfStep() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfStep = null;


        try {
            // InternalRsl.g:3658:47: (iv_ruleIfStep= ruleIfStep EOF )
            // InternalRsl.g:3659:2: iv_ruleIfStep= ruleIfStep EOF
            {
             newCompositeNode(grammarAccess.getIfStepRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIfStep=ruleIfStep();

            state._fsp--;

             current =iv_ruleIfStep; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIfStep"


    // $ANTLR start "ruleIfStep"
    // InternalRsl.g:3665:1: ruleIfStep returns [EObject current=null] : ( (otherlv_0= 'ifAction' ( ( ruleQualifiedName ) ) ) otherlv_2= '[' ( (lv_steps_3_0= ruleStep ) )+ otherlv_4= ']' ) ;
    public final EObject ruleIfStep() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_steps_3_0 = null;



        	enterRule();

        try {
            // InternalRsl.g:3671:2: ( ( (otherlv_0= 'ifAction' ( ( ruleQualifiedName ) ) ) otherlv_2= '[' ( (lv_steps_3_0= ruleStep ) )+ otherlv_4= ']' ) )
            // InternalRsl.g:3672:2: ( (otherlv_0= 'ifAction' ( ( ruleQualifiedName ) ) ) otherlv_2= '[' ( (lv_steps_3_0= ruleStep ) )+ otherlv_4= ']' )
            {
            // InternalRsl.g:3672:2: ( (otherlv_0= 'ifAction' ( ( ruleQualifiedName ) ) ) otherlv_2= '[' ( (lv_steps_3_0= ruleStep ) )+ otherlv_4= ']' )
            // InternalRsl.g:3673:3: (otherlv_0= 'ifAction' ( ( ruleQualifiedName ) ) ) otherlv_2= '[' ( (lv_steps_3_0= ruleStep ) )+ otherlv_4= ']'
            {
            // InternalRsl.g:3673:3: (otherlv_0= 'ifAction' ( ( ruleQualifiedName ) ) )
            // InternalRsl.g:3674:4: otherlv_0= 'ifAction' ( ( ruleQualifiedName ) )
            {
            otherlv_0=(Token)match(input,80,FOLLOW_5); 

            				newLeafNode(otherlv_0, grammarAccess.getIfStepAccess().getIfActionKeyword_0_0());
            			
            // InternalRsl.g:3678:4: ( ( ruleQualifiedName ) )
            // InternalRsl.g:3679:5: ( ruleQualifiedName )
            {
            // InternalRsl.g:3679:5: ( ruleQualifiedName )
            // InternalRsl.g:3680:6: ruleQualifiedName
            {

            						if (current==null) {
            							current = createModelElement(grammarAccess.getIfStepRule());
            						}
            					

            						newCompositeNode(grammarAccess.getIfStepAccess().getActionUCActionCrossReference_0_1_0());
            					
            pushFollow(FOLLOW_16);
            ruleQualifiedName();

            state._fsp--;


            						afterParserOrEnumRuleCall();
            					

            }


            }


            }

            otherlv_2=(Token)match(input,30,FOLLOW_84); 

            			newLeafNode(otherlv_2, grammarAccess.getIfStepAccess().getLeftSquareBracketKeyword_1());
            		
            // InternalRsl.g:3699:3: ( (lv_steps_3_0= ruleStep ) )+
            int cnt72=0;
            loop72:
            do {
                int alt72=2;
                int LA72_0 = input.LA(1);

                if ( (LA72_0==78) ) {
                    alt72=1;
                }


                switch (alt72) {
            	case 1 :
            	    // InternalRsl.g:3700:4: (lv_steps_3_0= ruleStep )
            	    {
            	    // InternalRsl.g:3700:4: (lv_steps_3_0= ruleStep )
            	    // InternalRsl.g:3701:5: lv_steps_3_0= ruleStep
            	    {

            	    					newCompositeNode(grammarAccess.getIfStepAccess().getStepsStepParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_74);
            	    lv_steps_3_0=ruleStep();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getIfStepRule());
            	    					}
            	    					add(
            	    						current,
            	    						"steps",
            	    						lv_steps_3_0,
            	    						"org.rslingo.rsl.Rsl.Step");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt72 >= 1 ) break loop72;
                        EarlyExitException eee =
                            new EarlyExitException(72, input);
                        throw eee;
                }
                cnt72++;
            } while (true);

            otherlv_4=(Token)match(input,36,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getIfStepAccess().getRightSquareBracketKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIfStep"


    // $ANTLR start "entryRuleStateMachine"
    // InternalRsl.g:3726:1: entryRuleStateMachine returns [EObject current=null] : iv_ruleStateMachine= ruleStateMachine EOF ;
    public final EObject entryRuleStateMachine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateMachine = null;


        try {
            // InternalRsl.g:3726:53: (iv_ruleStateMachine= ruleStateMachine EOF )
            // InternalRsl.g:3727:2: iv_ruleStateMachine= ruleStateMachine EOF
            {
             newCompositeNode(grammarAccess.getStateMachineRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStateMachine=ruleStateMachine();

            state._fsp--;

             current =iv_ruleStateMachine; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStateMachine"


    // $ANTLR start "ruleStateMachine"
    // InternalRsl.g:3733:1: ruleStateMachine returns [EObject current=null] : (otherlv_0= 'stateMachine' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleStateMachineType ) ) otherlv_4= '[' otherlv_5= 'name' ( (lv_nameAlias_6_0= RULE_STRING ) ) otherlv_7= 'dataEntity' ( (otherlv_8= RULE_ID ) ) (otherlv_9= 'description' ( (lv_description_10_0= RULE_STRING ) ) )? ( (lv_states_11_0= ruleStates ) ) otherlv_12= ']' ) ;
    public final EObject ruleStateMachine() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token lv_nameAlias_6_0=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token lv_description_10_0=null;
        Token otherlv_12=null;
        Enumerator lv_type_3_0 = null;

        EObject lv_states_11_0 = null;



        	enterRule();

        try {
            // InternalRsl.g:3739:2: ( (otherlv_0= 'stateMachine' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleStateMachineType ) ) otherlv_4= '[' otherlv_5= 'name' ( (lv_nameAlias_6_0= RULE_STRING ) ) otherlv_7= 'dataEntity' ( (otherlv_8= RULE_ID ) ) (otherlv_9= 'description' ( (lv_description_10_0= RULE_STRING ) ) )? ( (lv_states_11_0= ruleStates ) ) otherlv_12= ']' ) )
            // InternalRsl.g:3740:2: (otherlv_0= 'stateMachine' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleStateMachineType ) ) otherlv_4= '[' otherlv_5= 'name' ( (lv_nameAlias_6_0= RULE_STRING ) ) otherlv_7= 'dataEntity' ( (otherlv_8= RULE_ID ) ) (otherlv_9= 'description' ( (lv_description_10_0= RULE_STRING ) ) )? ( (lv_states_11_0= ruleStates ) ) otherlv_12= ']' )
            {
            // InternalRsl.g:3740:2: (otherlv_0= 'stateMachine' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleStateMachineType ) ) otherlv_4= '[' otherlv_5= 'name' ( (lv_nameAlias_6_0= RULE_STRING ) ) otherlv_7= 'dataEntity' ( (otherlv_8= RULE_ID ) ) (otherlv_9= 'description' ( (lv_description_10_0= RULE_STRING ) ) )? ( (lv_states_11_0= ruleStates ) ) otherlv_12= ']' )
            // InternalRsl.g:3741:3: otherlv_0= 'stateMachine' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleStateMachineType ) ) otherlv_4= '[' otherlv_5= 'name' ( (lv_nameAlias_6_0= RULE_STRING ) ) otherlv_7= 'dataEntity' ( (otherlv_8= RULE_ID ) ) (otherlv_9= 'description' ( (lv_description_10_0= RULE_STRING ) ) )? ( (lv_states_11_0= ruleStates ) ) otherlv_12= ']'
            {
            otherlv_0=(Token)match(input,81,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getStateMachineAccess().getStateMachineKeyword_0());
            		
            // InternalRsl.g:3745:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalRsl.g:3746:4: (lv_name_1_0= RULE_ID )
            {
            // InternalRsl.g:3746:4: (lv_name_1_0= RULE_ID )
            // InternalRsl.g:3747:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_14); 

            					newLeafNode(lv_name_1_0, grammarAccess.getStateMachineAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStateMachineRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,29,FOLLOW_28); 

            			newLeafNode(otherlv_2, grammarAccess.getStateMachineAccess().getColonKeyword_2());
            		
            // InternalRsl.g:3767:3: ( (lv_type_3_0= ruleStateMachineType ) )
            // InternalRsl.g:3768:4: (lv_type_3_0= ruleStateMachineType )
            {
            // InternalRsl.g:3768:4: (lv_type_3_0= ruleStateMachineType )
            // InternalRsl.g:3769:5: lv_type_3_0= ruleStateMachineType
            {

            					newCompositeNode(grammarAccess.getStateMachineAccess().getTypeStateMachineTypeEnumRuleCall_3_0());
            				
            pushFollow(FOLLOW_16);
            lv_type_3_0=ruleStateMachineType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getStateMachineRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_3_0,
            						"org.rslingo.rsl.Rsl.StateMachineType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,30,FOLLOW_17); 

            			newLeafNode(otherlv_4, grammarAccess.getStateMachineAccess().getLeftSquareBracketKeyword_4());
            		
            otherlv_5=(Token)match(input,31,FOLLOW_18); 

            			newLeafNode(otherlv_5, grammarAccess.getStateMachineAccess().getNameKeyword_5());
            		
            // InternalRsl.g:3794:3: ( (lv_nameAlias_6_0= RULE_STRING ) )
            // InternalRsl.g:3795:4: (lv_nameAlias_6_0= RULE_STRING )
            {
            // InternalRsl.g:3795:4: (lv_nameAlias_6_0= RULE_STRING )
            // InternalRsl.g:3796:5: lv_nameAlias_6_0= RULE_STRING
            {
            lv_nameAlias_6_0=(Token)match(input,RULE_STRING,FOLLOW_85); 

            					newLeafNode(lv_nameAlias_6_0, grammarAccess.getStateMachineAccess().getNameAliasSTRINGTerminalRuleCall_6_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStateMachineRule());
            					}
            					setWithLastConsumed(
            						current,
            						"nameAlias",
            						lv_nameAlias_6_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_7=(Token)match(input,38,FOLLOW_5); 

            			newLeafNode(otherlv_7, grammarAccess.getStateMachineAccess().getDataEntityKeyword_7());
            		
            // InternalRsl.g:3816:3: ( (otherlv_8= RULE_ID ) )
            // InternalRsl.g:3817:4: (otherlv_8= RULE_ID )
            {
            // InternalRsl.g:3817:4: (otherlv_8= RULE_ID )
            // InternalRsl.g:3818:5: otherlv_8= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStateMachineRule());
            					}
            				
            otherlv_8=(Token)match(input,RULE_ID,FOLLOW_86); 

            					newLeafNode(otherlv_8, grammarAccess.getStateMachineAccess().getEntityDataEntityCrossReference_8_0());
            				

            }


            }

            // InternalRsl.g:3829:3: (otherlv_9= 'description' ( (lv_description_10_0= RULE_STRING ) ) )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==35) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // InternalRsl.g:3830:4: otherlv_9= 'description' ( (lv_description_10_0= RULE_STRING ) )
                    {
                    otherlv_9=(Token)match(input,35,FOLLOW_18); 

                    				newLeafNode(otherlv_9, grammarAccess.getStateMachineAccess().getDescriptionKeyword_9_0());
                    			
                    // InternalRsl.g:3834:4: ( (lv_description_10_0= RULE_STRING ) )
                    // InternalRsl.g:3835:5: (lv_description_10_0= RULE_STRING )
                    {
                    // InternalRsl.g:3835:5: (lv_description_10_0= RULE_STRING )
                    // InternalRsl.g:3836:6: lv_description_10_0= RULE_STRING
                    {
                    lv_description_10_0=(Token)match(input,RULE_STRING,FOLLOW_87); 

                    						newLeafNode(lv_description_10_0, grammarAccess.getStateMachineAccess().getDescriptionSTRINGTerminalRuleCall_9_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getStateMachineRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"description",
                    							lv_description_10_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalRsl.g:3853:3: ( (lv_states_11_0= ruleStates ) )
            // InternalRsl.g:3854:4: (lv_states_11_0= ruleStates )
            {
            // InternalRsl.g:3854:4: (lv_states_11_0= ruleStates )
            // InternalRsl.g:3855:5: lv_states_11_0= ruleStates
            {

            					newCompositeNode(grammarAccess.getStateMachineAccess().getStatesStatesParserRuleCall_10_0());
            				
            pushFollow(FOLLOW_24);
            lv_states_11_0=ruleStates();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getStateMachineRule());
            					}
            					set(
            						current,
            						"states",
            						lv_states_11_0,
            						"org.rslingo.rsl.Rsl.States");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_12=(Token)match(input,36,FOLLOW_2); 

            			newLeafNode(otherlv_12, grammarAccess.getStateMachineAccess().getRightSquareBracketKeyword_11());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStateMachine"


    // $ANTLR start "entryRuleStates"
    // InternalRsl.g:3880:1: entryRuleStates returns [EObject current=null] : iv_ruleStates= ruleStates EOF ;
    public final EObject entryRuleStates() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStates = null;


        try {
            // InternalRsl.g:3880:47: (iv_ruleStates= ruleStates EOF )
            // InternalRsl.g:3881:2: iv_ruleStates= ruleStates EOF
            {
             newCompositeNode(grammarAccess.getStatesRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStates=ruleStates();

            state._fsp--;

             current =iv_ruleStates; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStates"


    // $ANTLR start "ruleStates"
    // InternalRsl.g:3887:1: ruleStates returns [EObject current=null] : ( () ( (lv_states_1_0= ruleState ) )* ) ;
    public final EObject ruleStates() throws RecognitionException {
        EObject current = null;

        EObject lv_states_1_0 = null;



        	enterRule();

        try {
            // InternalRsl.g:3893:2: ( ( () ( (lv_states_1_0= ruleState ) )* ) )
            // InternalRsl.g:3894:2: ( () ( (lv_states_1_0= ruleState ) )* )
            {
            // InternalRsl.g:3894:2: ( () ( (lv_states_1_0= ruleState ) )* )
            // InternalRsl.g:3895:3: () ( (lv_states_1_0= ruleState ) )*
            {
            // InternalRsl.g:3895:3: ()
            // InternalRsl.g:3896:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getStatesAccess().getStateAction_0(),
            					current);
            			

            }

            // InternalRsl.g:3902:3: ( (lv_states_1_0= ruleState ) )*
            loop74:
            do {
                int alt74=2;
                int LA74_0 = input.LA(1);

                if ( (LA74_0==82) ) {
                    alt74=1;
                }


                switch (alt74) {
            	case 1 :
            	    // InternalRsl.g:3903:4: (lv_states_1_0= ruleState )
            	    {
            	    // InternalRsl.g:3903:4: (lv_states_1_0= ruleState )
            	    // InternalRsl.g:3904:5: lv_states_1_0= ruleState
            	    {

            	    					newCompositeNode(grammarAccess.getStatesAccess().getStatesStateParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_88);
            	    lv_states_1_0=ruleState();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getStatesRule());
            	    					}
            	    					add(
            	    						current,
            	    						"states",
            	    						lv_states_1_0,
            	    						"org.rslingo.rsl.Rsl.State");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop74;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStates"


    // $ANTLR start "entryRuleState"
    // InternalRsl.g:3925:1: entryRuleState returns [EObject current=null] : iv_ruleState= ruleState EOF ;
    public final EObject entryRuleState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleState = null;


        try {
            // InternalRsl.g:3925:46: (iv_ruleState= ruleState EOF )
            // InternalRsl.g:3926:2: iv_ruleState= ruleState EOF
            {
             newCompositeNode(grammarAccess.getStateRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleState=ruleState();

            state._fsp--;

             current =iv_ruleState; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleState"


    // $ANTLR start "ruleState"
    // InternalRsl.g:3932:1: ruleState returns [EObject current=null] : (otherlv_0= 'state' ( (lv_name_1_0= RULE_ID ) ) ( (lv_isInitial_2_0= 'isInitial' ) )? ( (lv_isFinal_3_0= 'isFinal' ) )? (otherlv_4= 'onEntry' ( (lv_onEntry_5_0= RULE_STRING ) ) )? (otherlv_6= 'onExit' ( (lv_onExit_7_0= RULE_STRING ) ) )? (otherlv_8= ':' ( (lv_actions_9_0= ruleRefUCAction ) ) )? ( (lv_actions_10_0= ruleRefUCAction ) )* ) ;
    public final EObject ruleState() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token lv_isInitial_2_0=null;
        Token lv_isFinal_3_0=null;
        Token otherlv_4=null;
        Token lv_onEntry_5_0=null;
        Token otherlv_6=null;
        Token lv_onExit_7_0=null;
        Token otherlv_8=null;
        EObject lv_actions_9_0 = null;

        EObject lv_actions_10_0 = null;



        	enterRule();

        try {
            // InternalRsl.g:3938:2: ( (otherlv_0= 'state' ( (lv_name_1_0= RULE_ID ) ) ( (lv_isInitial_2_0= 'isInitial' ) )? ( (lv_isFinal_3_0= 'isFinal' ) )? (otherlv_4= 'onEntry' ( (lv_onEntry_5_0= RULE_STRING ) ) )? (otherlv_6= 'onExit' ( (lv_onExit_7_0= RULE_STRING ) ) )? (otherlv_8= ':' ( (lv_actions_9_0= ruleRefUCAction ) ) )? ( (lv_actions_10_0= ruleRefUCAction ) )* ) )
            // InternalRsl.g:3939:2: (otherlv_0= 'state' ( (lv_name_1_0= RULE_ID ) ) ( (lv_isInitial_2_0= 'isInitial' ) )? ( (lv_isFinal_3_0= 'isFinal' ) )? (otherlv_4= 'onEntry' ( (lv_onEntry_5_0= RULE_STRING ) ) )? (otherlv_6= 'onExit' ( (lv_onExit_7_0= RULE_STRING ) ) )? (otherlv_8= ':' ( (lv_actions_9_0= ruleRefUCAction ) ) )? ( (lv_actions_10_0= ruleRefUCAction ) )* )
            {
            // InternalRsl.g:3939:2: (otherlv_0= 'state' ( (lv_name_1_0= RULE_ID ) ) ( (lv_isInitial_2_0= 'isInitial' ) )? ( (lv_isFinal_3_0= 'isFinal' ) )? (otherlv_4= 'onEntry' ( (lv_onEntry_5_0= RULE_STRING ) ) )? (otherlv_6= 'onExit' ( (lv_onExit_7_0= RULE_STRING ) ) )? (otherlv_8= ':' ( (lv_actions_9_0= ruleRefUCAction ) ) )? ( (lv_actions_10_0= ruleRefUCAction ) )* )
            // InternalRsl.g:3940:3: otherlv_0= 'state' ( (lv_name_1_0= RULE_ID ) ) ( (lv_isInitial_2_0= 'isInitial' ) )? ( (lv_isFinal_3_0= 'isFinal' ) )? (otherlv_4= 'onEntry' ( (lv_onEntry_5_0= RULE_STRING ) ) )? (otherlv_6= 'onExit' ( (lv_onExit_7_0= RULE_STRING ) ) )? (otherlv_8= ':' ( (lv_actions_9_0= ruleRefUCAction ) ) )? ( (lv_actions_10_0= ruleRefUCAction ) )*
            {
            otherlv_0=(Token)match(input,82,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getStateAccess().getStateKeyword_0());
            		
            // InternalRsl.g:3944:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalRsl.g:3945:4: (lv_name_1_0= RULE_ID )
            {
            // InternalRsl.g:3945:4: (lv_name_1_0= RULE_ID )
            // InternalRsl.g:3946:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_89); 

            					newLeafNode(lv_name_1_0, grammarAccess.getStateAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStateRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalRsl.g:3962:3: ( (lv_isInitial_2_0= 'isInitial' ) )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==83) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // InternalRsl.g:3963:4: (lv_isInitial_2_0= 'isInitial' )
                    {
                    // InternalRsl.g:3963:4: (lv_isInitial_2_0= 'isInitial' )
                    // InternalRsl.g:3964:5: lv_isInitial_2_0= 'isInitial'
                    {
                    lv_isInitial_2_0=(Token)match(input,83,FOLLOW_90); 

                    					newLeafNode(lv_isInitial_2_0, grammarAccess.getStateAccess().getIsInitialIsInitialKeyword_2_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getStateRule());
                    					}
                    					setWithLastConsumed(current, "isInitial", true, "isInitial");
                    				

                    }


                    }
                    break;

            }

            // InternalRsl.g:3976:3: ( (lv_isFinal_3_0= 'isFinal' ) )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==84) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // InternalRsl.g:3977:4: (lv_isFinal_3_0= 'isFinal' )
                    {
                    // InternalRsl.g:3977:4: (lv_isFinal_3_0= 'isFinal' )
                    // InternalRsl.g:3978:5: lv_isFinal_3_0= 'isFinal'
                    {
                    lv_isFinal_3_0=(Token)match(input,84,FOLLOW_91); 

                    					newLeafNode(lv_isFinal_3_0, grammarAccess.getStateAccess().getIsFinalIsFinalKeyword_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getStateRule());
                    					}
                    					setWithLastConsumed(current, "isFinal", true, "isFinal");
                    				

                    }


                    }
                    break;

            }

            // InternalRsl.g:3990:3: (otherlv_4= 'onEntry' ( (lv_onEntry_5_0= RULE_STRING ) ) )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==85) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // InternalRsl.g:3991:4: otherlv_4= 'onEntry' ( (lv_onEntry_5_0= RULE_STRING ) )
                    {
                    otherlv_4=(Token)match(input,85,FOLLOW_18); 

                    				newLeafNode(otherlv_4, grammarAccess.getStateAccess().getOnEntryKeyword_4_0());
                    			
                    // InternalRsl.g:3995:4: ( (lv_onEntry_5_0= RULE_STRING ) )
                    // InternalRsl.g:3996:5: (lv_onEntry_5_0= RULE_STRING )
                    {
                    // InternalRsl.g:3996:5: (lv_onEntry_5_0= RULE_STRING )
                    // InternalRsl.g:3997:6: lv_onEntry_5_0= RULE_STRING
                    {
                    lv_onEntry_5_0=(Token)match(input,RULE_STRING,FOLLOW_92); 

                    						newLeafNode(lv_onEntry_5_0, grammarAccess.getStateAccess().getOnEntrySTRINGTerminalRuleCall_4_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getStateRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"onEntry",
                    							lv_onEntry_5_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalRsl.g:4014:3: (otherlv_6= 'onExit' ( (lv_onExit_7_0= RULE_STRING ) ) )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==86) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    // InternalRsl.g:4015:4: otherlv_6= 'onExit' ( (lv_onExit_7_0= RULE_STRING ) )
                    {
                    otherlv_6=(Token)match(input,86,FOLLOW_18); 

                    				newLeafNode(otherlv_6, grammarAccess.getStateAccess().getOnExitKeyword_5_0());
                    			
                    // InternalRsl.g:4019:4: ( (lv_onExit_7_0= RULE_STRING ) )
                    // InternalRsl.g:4020:5: (lv_onExit_7_0= RULE_STRING )
                    {
                    // InternalRsl.g:4020:5: (lv_onExit_7_0= RULE_STRING )
                    // InternalRsl.g:4021:6: lv_onExit_7_0= RULE_STRING
                    {
                    lv_onExit_7_0=(Token)match(input,RULE_STRING,FOLLOW_93); 

                    						newLeafNode(lv_onExit_7_0, grammarAccess.getStateAccess().getOnExitSTRINGTerminalRuleCall_5_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getStateRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"onExit",
                    							lv_onExit_7_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalRsl.g:4038:3: (otherlv_8= ':' ( (lv_actions_9_0= ruleRefUCAction ) ) )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==29) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // InternalRsl.g:4039:4: otherlv_8= ':' ( (lv_actions_9_0= ruleRefUCAction ) )
                    {
                    otherlv_8=(Token)match(input,29,FOLLOW_94); 

                    				newLeafNode(otherlv_8, grammarAccess.getStateAccess().getColonKeyword_6_0());
                    			
                    // InternalRsl.g:4043:4: ( (lv_actions_9_0= ruleRefUCAction ) )
                    // InternalRsl.g:4044:5: (lv_actions_9_0= ruleRefUCAction )
                    {
                    // InternalRsl.g:4044:5: (lv_actions_9_0= ruleRefUCAction )
                    // InternalRsl.g:4045:6: lv_actions_9_0= ruleRefUCAction
                    {

                    						newCompositeNode(grammarAccess.getStateAccess().getActionsRefUCActionParserRuleCall_6_1_0());
                    					
                    pushFollow(FOLLOW_95);
                    lv_actions_9_0=ruleRefUCAction();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getStateRule());
                    						}
                    						add(
                    							current,
                    							"actions",
                    							lv_actions_9_0,
                    							"org.rslingo.rsl.Rsl.RefUCAction");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalRsl.g:4063:3: ( (lv_actions_10_0= ruleRefUCAction ) )*
            loop80:
            do {
                int alt80=2;
                int LA80_0 = input.LA(1);

                if ( (LA80_0==87) ) {
                    alt80=1;
                }


                switch (alt80) {
            	case 1 :
            	    // InternalRsl.g:4064:4: (lv_actions_10_0= ruleRefUCAction )
            	    {
            	    // InternalRsl.g:4064:4: (lv_actions_10_0= ruleRefUCAction )
            	    // InternalRsl.g:4065:5: lv_actions_10_0= ruleRefUCAction
            	    {

            	    					newCompositeNode(grammarAccess.getStateAccess().getActionsRefUCActionParserRuleCall_7_0());
            	    				
            	    pushFollow(FOLLOW_95);
            	    lv_actions_10_0=ruleRefUCAction();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getStateRule());
            	    					}
            	    					add(
            	    						current,
            	    						"actions",
            	    						lv_actions_10_0,
            	    						"org.rslingo.rsl.Rsl.RefUCAction");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop80;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleState"


    // $ANTLR start "entryRuleRefUCAction"
    // InternalRsl.g:4086:1: entryRuleRefUCAction returns [EObject current=null] : iv_ruleRefUCAction= ruleRefUCAction EOF ;
    public final EObject entryRuleRefUCAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefUCAction = null;


        try {
            // InternalRsl.g:4086:52: (iv_ruleRefUCAction= ruleRefUCAction EOF )
            // InternalRsl.g:4087:2: iv_ruleRefUCAction= ruleRefUCAction EOF
            {
             newCompositeNode(grammarAccess.getRefUCActionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRefUCAction=ruleRefUCAction();

            state._fsp--;

             current =iv_ruleRefUCAction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRefUCAction"


    // $ANTLR start "ruleRefUCAction"
    // InternalRsl.g:4093:1: ruleRefUCAction returns [EObject current=null] : (otherlv_0= 'useCaseAction' ( ( ruleQualifiedName ) ) (otherlv_2= 'nextState' ( (otherlv_3= RULE_ID ) ) )? ) ;
    public final EObject ruleRefUCAction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalRsl.g:4099:2: ( (otherlv_0= 'useCaseAction' ( ( ruleQualifiedName ) ) (otherlv_2= 'nextState' ( (otherlv_3= RULE_ID ) ) )? ) )
            // InternalRsl.g:4100:2: (otherlv_0= 'useCaseAction' ( ( ruleQualifiedName ) ) (otherlv_2= 'nextState' ( (otherlv_3= RULE_ID ) ) )? )
            {
            // InternalRsl.g:4100:2: (otherlv_0= 'useCaseAction' ( ( ruleQualifiedName ) ) (otherlv_2= 'nextState' ( (otherlv_3= RULE_ID ) ) )? )
            // InternalRsl.g:4101:3: otherlv_0= 'useCaseAction' ( ( ruleQualifiedName ) ) (otherlv_2= 'nextState' ( (otherlv_3= RULE_ID ) ) )?
            {
            otherlv_0=(Token)match(input,87,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getRefUCActionAccess().getUseCaseActionKeyword_0());
            		
            // InternalRsl.g:4105:3: ( ( ruleQualifiedName ) )
            // InternalRsl.g:4106:4: ( ruleQualifiedName )
            {
            // InternalRsl.g:4106:4: ( ruleQualifiedName )
            // InternalRsl.g:4107:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRefUCActionRule());
            					}
            				

            					newCompositeNode(grammarAccess.getRefUCActionAccess().getActionUCActionCrossReference_1_0());
            				
            pushFollow(FOLLOW_96);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRsl.g:4121:3: (otherlv_2= 'nextState' ( (otherlv_3= RULE_ID ) ) )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==88) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    // InternalRsl.g:4122:4: otherlv_2= 'nextState' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,88,FOLLOW_5); 

                    				newLeafNode(otherlv_2, grammarAccess.getRefUCActionAccess().getNextStateKeyword_2_0());
                    			
                    // InternalRsl.g:4126:4: ( (otherlv_3= RULE_ID ) )
                    // InternalRsl.g:4127:5: (otherlv_3= RULE_ID )
                    {
                    // InternalRsl.g:4127:5: (otherlv_3= RULE_ID )
                    // InternalRsl.g:4128:6: otherlv_3= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getRefUCActionRule());
                    						}
                    					
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_2); 

                    						newLeafNode(otherlv_3, grammarAccess.getRefUCActionAccess().getNextstateStateCrossReference_2_1_0());
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRefUCAction"


    // $ANTLR start "ruleSystemType"
    // InternalRsl.g:4144:1: ruleSystemType returns [Enumerator current=null] : ( (enumLiteral_0= 'System' ) | (enumLiteral_1= 'SubSystem' ) | (enumLiteral_2= 'ReusableSystem' ) | (enumLiteral_3= 'Application' ) | (enumLiteral_4= 'Other' ) ) ;
    public final Enumerator ruleSystemType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;


        	enterRule();

        try {
            // InternalRsl.g:4150:2: ( ( (enumLiteral_0= 'System' ) | (enumLiteral_1= 'SubSystem' ) | (enumLiteral_2= 'ReusableSystem' ) | (enumLiteral_3= 'Application' ) | (enumLiteral_4= 'Other' ) ) )
            // InternalRsl.g:4151:2: ( (enumLiteral_0= 'System' ) | (enumLiteral_1= 'SubSystem' ) | (enumLiteral_2= 'ReusableSystem' ) | (enumLiteral_3= 'Application' ) | (enumLiteral_4= 'Other' ) )
            {
            // InternalRsl.g:4151:2: ( (enumLiteral_0= 'System' ) | (enumLiteral_1= 'SubSystem' ) | (enumLiteral_2= 'ReusableSystem' ) | (enumLiteral_3= 'Application' ) | (enumLiteral_4= 'Other' ) )
            int alt82=5;
            switch ( input.LA(1) ) {
            case 89:
                {
                alt82=1;
                }
                break;
            case 90:
                {
                alt82=2;
                }
                break;
            case 91:
                {
                alt82=3;
                }
                break;
            case 92:
                {
                alt82=4;
                }
                break;
            case 93:
                {
                alt82=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 82, 0, input);

                throw nvae;
            }

            switch (alt82) {
                case 1 :
                    // InternalRsl.g:4152:3: (enumLiteral_0= 'System' )
                    {
                    // InternalRsl.g:4152:3: (enumLiteral_0= 'System' )
                    // InternalRsl.g:4153:4: enumLiteral_0= 'System'
                    {
                    enumLiteral_0=(Token)match(input,89,FOLLOW_2); 

                    				current = grammarAccess.getSystemTypeAccess().getSystemEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getSystemTypeAccess().getSystemEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalRsl.g:4160:3: (enumLiteral_1= 'SubSystem' )
                    {
                    // InternalRsl.g:4160:3: (enumLiteral_1= 'SubSystem' )
                    // InternalRsl.g:4161:4: enumLiteral_1= 'SubSystem'
                    {
                    enumLiteral_1=(Token)match(input,90,FOLLOW_2); 

                    				current = grammarAccess.getSystemTypeAccess().getSubSystemEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getSystemTypeAccess().getSubSystemEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalRsl.g:4168:3: (enumLiteral_2= 'ReusableSystem' )
                    {
                    // InternalRsl.g:4168:3: (enumLiteral_2= 'ReusableSystem' )
                    // InternalRsl.g:4169:4: enumLiteral_2= 'ReusableSystem'
                    {
                    enumLiteral_2=(Token)match(input,91,FOLLOW_2); 

                    				current = grammarAccess.getSystemTypeAccess().getReusableSystemEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getSystemTypeAccess().getReusableSystemEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalRsl.g:4176:3: (enumLiteral_3= 'Application' )
                    {
                    // InternalRsl.g:4176:3: (enumLiteral_3= 'Application' )
                    // InternalRsl.g:4177:4: enumLiteral_3= 'Application'
                    {
                    enumLiteral_3=(Token)match(input,92,FOLLOW_2); 

                    				current = grammarAccess.getSystemTypeAccess().getApplicationEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getSystemTypeAccess().getApplicationEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalRsl.g:4184:3: (enumLiteral_4= 'Other' )
                    {
                    // InternalRsl.g:4184:3: (enumLiteral_4= 'Other' )
                    // InternalRsl.g:4185:4: enumLiteral_4= 'Other'
                    {
                    enumLiteral_4=(Token)match(input,93,FOLLOW_2); 

                    				current = grammarAccess.getSystemTypeAccess().getOtherEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getSystemTypeAccess().getOtherEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSystemType"


    // $ANTLR start "ruleSystemScope"
    // InternalRsl.g:4195:1: ruleSystemScope returns [Enumerator current=null] : ( (enumLiteral_0= 'In' ) | (enumLiteral_1= 'Out' ) ) ;
    public final Enumerator ruleSystemScope() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalRsl.g:4201:2: ( ( (enumLiteral_0= 'In' ) | (enumLiteral_1= 'Out' ) ) )
            // InternalRsl.g:4202:2: ( (enumLiteral_0= 'In' ) | (enumLiteral_1= 'Out' ) )
            {
            // InternalRsl.g:4202:2: ( (enumLiteral_0= 'In' ) | (enumLiteral_1= 'Out' ) )
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==94) ) {
                alt83=1;
            }
            else if ( (LA83_0==95) ) {
                alt83=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 83, 0, input);

                throw nvae;
            }
            switch (alt83) {
                case 1 :
                    // InternalRsl.g:4203:3: (enumLiteral_0= 'In' )
                    {
                    // InternalRsl.g:4203:3: (enumLiteral_0= 'In' )
                    // InternalRsl.g:4204:4: enumLiteral_0= 'In'
                    {
                    enumLiteral_0=(Token)match(input,94,FOLLOW_2); 

                    				current = grammarAccess.getSystemScopeAccess().getInEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getSystemScopeAccess().getInEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalRsl.g:4211:3: (enumLiteral_1= 'Out' )
                    {
                    // InternalRsl.g:4211:3: (enumLiteral_1= 'Out' )
                    // InternalRsl.g:4212:4: enumLiteral_1= 'Out'
                    {
                    enumLiteral_1=(Token)match(input,95,FOLLOW_2); 

                    				current = grammarAccess.getSystemScopeAccess().getOutEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getSystemScopeAccess().getOutEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSystemScope"


    // $ANTLR start "ruleSystemRelationType"
    // InternalRsl.g:4222:1: ruleSystemRelationType returns [Enumerator current=null] : ( (enumLiteral_0= 'Requires' ) | (enumLiteral_1= 'Supports' ) | (enumLiteral_2= 'Obstructs' ) | (enumLiteral_3= 'Conflicts' ) | (enumLiteral_4= 'Identical' ) | (enumLiteral_5= 'Relates' ) | (enumLiteral_6= 'Other' ) ) ;
    public final Enumerator ruleSystemRelationType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;


        	enterRule();

        try {
            // InternalRsl.g:4228:2: ( ( (enumLiteral_0= 'Requires' ) | (enumLiteral_1= 'Supports' ) | (enumLiteral_2= 'Obstructs' ) | (enumLiteral_3= 'Conflicts' ) | (enumLiteral_4= 'Identical' ) | (enumLiteral_5= 'Relates' ) | (enumLiteral_6= 'Other' ) ) )
            // InternalRsl.g:4229:2: ( (enumLiteral_0= 'Requires' ) | (enumLiteral_1= 'Supports' ) | (enumLiteral_2= 'Obstructs' ) | (enumLiteral_3= 'Conflicts' ) | (enumLiteral_4= 'Identical' ) | (enumLiteral_5= 'Relates' ) | (enumLiteral_6= 'Other' ) )
            {
            // InternalRsl.g:4229:2: ( (enumLiteral_0= 'Requires' ) | (enumLiteral_1= 'Supports' ) | (enumLiteral_2= 'Obstructs' ) | (enumLiteral_3= 'Conflicts' ) | (enumLiteral_4= 'Identical' ) | (enumLiteral_5= 'Relates' ) | (enumLiteral_6= 'Other' ) )
            int alt84=7;
            switch ( input.LA(1) ) {
            case 96:
                {
                alt84=1;
                }
                break;
            case 97:
                {
                alt84=2;
                }
                break;
            case 98:
                {
                alt84=3;
                }
                break;
            case 99:
                {
                alt84=4;
                }
                break;
            case 100:
                {
                alt84=5;
                }
                break;
            case 101:
                {
                alt84=6;
                }
                break;
            case 93:
                {
                alt84=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 84, 0, input);

                throw nvae;
            }

            switch (alt84) {
                case 1 :
                    // InternalRsl.g:4230:3: (enumLiteral_0= 'Requires' )
                    {
                    // InternalRsl.g:4230:3: (enumLiteral_0= 'Requires' )
                    // InternalRsl.g:4231:4: enumLiteral_0= 'Requires'
                    {
                    enumLiteral_0=(Token)match(input,96,FOLLOW_2); 

                    				current = grammarAccess.getSystemRelationTypeAccess().getRequiresEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getSystemRelationTypeAccess().getRequiresEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalRsl.g:4238:3: (enumLiteral_1= 'Supports' )
                    {
                    // InternalRsl.g:4238:3: (enumLiteral_1= 'Supports' )
                    // InternalRsl.g:4239:4: enumLiteral_1= 'Supports'
                    {
                    enumLiteral_1=(Token)match(input,97,FOLLOW_2); 

                    				current = grammarAccess.getSystemRelationTypeAccess().getSupportsEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getSystemRelationTypeAccess().getSupportsEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalRsl.g:4246:3: (enumLiteral_2= 'Obstructs' )
                    {
                    // InternalRsl.g:4246:3: (enumLiteral_2= 'Obstructs' )
                    // InternalRsl.g:4247:4: enumLiteral_2= 'Obstructs'
                    {
                    enumLiteral_2=(Token)match(input,98,FOLLOW_2); 

                    				current = grammarAccess.getSystemRelationTypeAccess().getObstructsEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getSystemRelationTypeAccess().getObstructsEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalRsl.g:4254:3: (enumLiteral_3= 'Conflicts' )
                    {
                    // InternalRsl.g:4254:3: (enumLiteral_3= 'Conflicts' )
                    // InternalRsl.g:4255:4: enumLiteral_3= 'Conflicts'
                    {
                    enumLiteral_3=(Token)match(input,99,FOLLOW_2); 

                    				current = grammarAccess.getSystemRelationTypeAccess().getConflictsEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getSystemRelationTypeAccess().getConflictsEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalRsl.g:4262:3: (enumLiteral_4= 'Identical' )
                    {
                    // InternalRsl.g:4262:3: (enumLiteral_4= 'Identical' )
                    // InternalRsl.g:4263:4: enumLiteral_4= 'Identical'
                    {
                    enumLiteral_4=(Token)match(input,100,FOLLOW_2); 

                    				current = grammarAccess.getSystemRelationTypeAccess().getIdenticalEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getSystemRelationTypeAccess().getIdenticalEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalRsl.g:4270:3: (enumLiteral_5= 'Relates' )
                    {
                    // InternalRsl.g:4270:3: (enumLiteral_5= 'Relates' )
                    // InternalRsl.g:4271:4: enumLiteral_5= 'Relates'
                    {
                    enumLiteral_5=(Token)match(input,101,FOLLOW_2); 

                    				current = grammarAccess.getSystemRelationTypeAccess().getRelatesEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getSystemRelationTypeAccess().getRelatesEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalRsl.g:4278:3: (enumLiteral_6= 'Other' )
                    {
                    // InternalRsl.g:4278:3: (enumLiteral_6= 'Other' )
                    // InternalRsl.g:4279:4: enumLiteral_6= 'Other'
                    {
                    enumLiteral_6=(Token)match(input,93,FOLLOW_2); 

                    				current = grammarAccess.getSystemRelationTypeAccess().getOtherEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getSystemRelationTypeAccess().getOtherEnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSystemRelationType"


    // $ANTLR start "ruleSystemRelationCategory"
    // InternalRsl.g:4289:1: ruleSystemRelationCategory returns [Enumerator current=null] : ( (enumLiteral_0= 'Import' ) | (enumLiteral_1= 'Export' ) | (enumLiteral_2= 'ImportExport' ) | (enumLiteral_3= 'Sync' ) | (enumLiteral_4= 'Interact' ) | (enumLiteral_5= 'Other' ) ) ;
    public final Enumerator ruleSystemRelationCategory() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;


        	enterRule();

        try {
            // InternalRsl.g:4295:2: ( ( (enumLiteral_0= 'Import' ) | (enumLiteral_1= 'Export' ) | (enumLiteral_2= 'ImportExport' ) | (enumLiteral_3= 'Sync' ) | (enumLiteral_4= 'Interact' ) | (enumLiteral_5= 'Other' ) ) )
            // InternalRsl.g:4296:2: ( (enumLiteral_0= 'Import' ) | (enumLiteral_1= 'Export' ) | (enumLiteral_2= 'ImportExport' ) | (enumLiteral_3= 'Sync' ) | (enumLiteral_4= 'Interact' ) | (enumLiteral_5= 'Other' ) )
            {
            // InternalRsl.g:4296:2: ( (enumLiteral_0= 'Import' ) | (enumLiteral_1= 'Export' ) | (enumLiteral_2= 'ImportExport' ) | (enumLiteral_3= 'Sync' ) | (enumLiteral_4= 'Interact' ) | (enumLiteral_5= 'Other' ) )
            int alt85=6;
            switch ( input.LA(1) ) {
            case 102:
                {
                alt85=1;
                }
                break;
            case 103:
                {
                alt85=2;
                }
                break;
            case 104:
                {
                alt85=3;
                }
                break;
            case 105:
                {
                alt85=4;
                }
                break;
            case 106:
                {
                alt85=5;
                }
                break;
            case 93:
                {
                alt85=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 85, 0, input);

                throw nvae;
            }

            switch (alt85) {
                case 1 :
                    // InternalRsl.g:4297:3: (enumLiteral_0= 'Import' )
                    {
                    // InternalRsl.g:4297:3: (enumLiteral_0= 'Import' )
                    // InternalRsl.g:4298:4: enumLiteral_0= 'Import'
                    {
                    enumLiteral_0=(Token)match(input,102,FOLLOW_2); 

                    				current = grammarAccess.getSystemRelationCategoryAccess().getImportEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getSystemRelationCategoryAccess().getImportEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalRsl.g:4305:3: (enumLiteral_1= 'Export' )
                    {
                    // InternalRsl.g:4305:3: (enumLiteral_1= 'Export' )
                    // InternalRsl.g:4306:4: enumLiteral_1= 'Export'
                    {
                    enumLiteral_1=(Token)match(input,103,FOLLOW_2); 

                    				current = grammarAccess.getSystemRelationCategoryAccess().getExportEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getSystemRelationCategoryAccess().getExportEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalRsl.g:4313:3: (enumLiteral_2= 'ImportExport' )
                    {
                    // InternalRsl.g:4313:3: (enumLiteral_2= 'ImportExport' )
                    // InternalRsl.g:4314:4: enumLiteral_2= 'ImportExport'
                    {
                    enumLiteral_2=(Token)match(input,104,FOLLOW_2); 

                    				current = grammarAccess.getSystemRelationCategoryAccess().getImportExportEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getSystemRelationCategoryAccess().getImportExportEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalRsl.g:4321:3: (enumLiteral_3= 'Sync' )
                    {
                    // InternalRsl.g:4321:3: (enumLiteral_3= 'Sync' )
                    // InternalRsl.g:4322:4: enumLiteral_3= 'Sync'
                    {
                    enumLiteral_3=(Token)match(input,105,FOLLOW_2); 

                    				current = grammarAccess.getSystemRelationCategoryAccess().getSyncEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getSystemRelationCategoryAccess().getSyncEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalRsl.g:4329:3: (enumLiteral_4= 'Interact' )
                    {
                    // InternalRsl.g:4329:3: (enumLiteral_4= 'Interact' )
                    // InternalRsl.g:4330:4: enumLiteral_4= 'Interact'
                    {
                    enumLiteral_4=(Token)match(input,106,FOLLOW_2); 

                    				current = grammarAccess.getSystemRelationCategoryAccess().getInteractEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getSystemRelationCategoryAccess().getInteractEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalRsl.g:4337:3: (enumLiteral_5= 'Other' )
                    {
                    // InternalRsl.g:4337:3: (enumLiteral_5= 'Other' )
                    // InternalRsl.g:4338:4: enumLiteral_5= 'Other'
                    {
                    enumLiteral_5=(Token)match(input,93,FOLLOW_2); 

                    				current = grammarAccess.getSystemRelationCategoryAccess().getOtherEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getSystemRelationCategoryAccess().getOtherEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSystemRelationCategory"


    // $ANTLR start "ruleDataEntityType"
    // InternalRsl.g:4348:1: ruleDataEntityType returns [Enumerator current=null] : ( (enumLiteral_0= 'Principal' ) | (enumLiteral_1= 'Secondary' ) ) ;
    public final Enumerator ruleDataEntityType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalRsl.g:4354:2: ( ( (enumLiteral_0= 'Principal' ) | (enumLiteral_1= 'Secondary' ) ) )
            // InternalRsl.g:4355:2: ( (enumLiteral_0= 'Principal' ) | (enumLiteral_1= 'Secondary' ) )
            {
            // InternalRsl.g:4355:2: ( (enumLiteral_0= 'Principal' ) | (enumLiteral_1= 'Secondary' ) )
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==107) ) {
                alt86=1;
            }
            else if ( (LA86_0==108) ) {
                alt86=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 86, 0, input);

                throw nvae;
            }
            switch (alt86) {
                case 1 :
                    // InternalRsl.g:4356:3: (enumLiteral_0= 'Principal' )
                    {
                    // InternalRsl.g:4356:3: (enumLiteral_0= 'Principal' )
                    // InternalRsl.g:4357:4: enumLiteral_0= 'Principal'
                    {
                    enumLiteral_0=(Token)match(input,107,FOLLOW_2); 

                    				current = grammarAccess.getDataEntityTypeAccess().getPrincipalEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getDataEntityTypeAccess().getPrincipalEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalRsl.g:4364:3: (enumLiteral_1= 'Secondary' )
                    {
                    // InternalRsl.g:4364:3: (enumLiteral_1= 'Secondary' )
                    // InternalRsl.g:4365:4: enumLiteral_1= 'Secondary'
                    {
                    enumLiteral_1=(Token)match(input,108,FOLLOW_2); 

                    				current = grammarAccess.getDataEntityTypeAccess().getSecondaryEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getDataEntityTypeAccess().getSecondaryEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDataEntityType"


    // $ANTLR start "ruleDataEntitySubType"
    // InternalRsl.g:4375:1: ruleDataEntitySubType returns [Enumerator current=null] : ( (enumLiteral_0= 'Simple' ) | (enumLiteral_1= 'Complex' ) ) ;
    public final Enumerator ruleDataEntitySubType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalRsl.g:4381:2: ( ( (enumLiteral_0= 'Simple' ) | (enumLiteral_1= 'Complex' ) ) )
            // InternalRsl.g:4382:2: ( (enumLiteral_0= 'Simple' ) | (enumLiteral_1= 'Complex' ) )
            {
            // InternalRsl.g:4382:2: ( (enumLiteral_0= 'Simple' ) | (enumLiteral_1= 'Complex' ) )
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==109) ) {
                alt87=1;
            }
            else if ( (LA87_0==110) ) {
                alt87=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 87, 0, input);

                throw nvae;
            }
            switch (alt87) {
                case 1 :
                    // InternalRsl.g:4383:3: (enumLiteral_0= 'Simple' )
                    {
                    // InternalRsl.g:4383:3: (enumLiteral_0= 'Simple' )
                    // InternalRsl.g:4384:4: enumLiteral_0= 'Simple'
                    {
                    enumLiteral_0=(Token)match(input,109,FOLLOW_2); 

                    				current = grammarAccess.getDataEntitySubTypeAccess().getSimpleEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getDataEntitySubTypeAccess().getSimpleEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalRsl.g:4391:3: (enumLiteral_1= 'Complex' )
                    {
                    // InternalRsl.g:4391:3: (enumLiteral_1= 'Complex' )
                    // InternalRsl.g:4392:4: enumLiteral_1= 'Complex'
                    {
                    enumLiteral_1=(Token)match(input,110,FOLLOW_2); 

                    				current = grammarAccess.getDataEntitySubTypeAccess().getComplexEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getDataEntitySubTypeAccess().getComplexEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDataEntitySubType"


    // $ANTLR start "ruleAttributeType"
    // InternalRsl.g:4402:1: ruleAttributeType returns [Enumerator current=null] : ( (enumLiteral_0= 'Integer' ) | (enumLiteral_1= 'Double' ) | (enumLiteral_2= 'Decimal' ) | (enumLiteral_3= 'Boolean' ) | (enumLiteral_4= 'Bit' ) | (enumLiteral_5= 'Currency' ) | (enumLiteral_6= 'Date' ) | (enumLiteral_7= 'Time' ) | (enumLiteral_8= 'Datetime' ) | (enumLiteral_9= 'String' ) | (enumLiteral_10= 'Text' ) | (enumLiteral_11= 'Regex' ) | (enumLiteral_12= 'URL' ) | (enumLiteral_13= 'Image' ) | (enumLiteral_14= 'XML' ) | (enumLiteral_15= 'Binary' ) ) ;
    public final Enumerator ruleAttributeType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;
        Token enumLiteral_8=null;
        Token enumLiteral_9=null;
        Token enumLiteral_10=null;
        Token enumLiteral_11=null;
        Token enumLiteral_12=null;
        Token enumLiteral_13=null;
        Token enumLiteral_14=null;
        Token enumLiteral_15=null;


        	enterRule();

        try {
            // InternalRsl.g:4408:2: ( ( (enumLiteral_0= 'Integer' ) | (enumLiteral_1= 'Double' ) | (enumLiteral_2= 'Decimal' ) | (enumLiteral_3= 'Boolean' ) | (enumLiteral_4= 'Bit' ) | (enumLiteral_5= 'Currency' ) | (enumLiteral_6= 'Date' ) | (enumLiteral_7= 'Time' ) | (enumLiteral_8= 'Datetime' ) | (enumLiteral_9= 'String' ) | (enumLiteral_10= 'Text' ) | (enumLiteral_11= 'Regex' ) | (enumLiteral_12= 'URL' ) | (enumLiteral_13= 'Image' ) | (enumLiteral_14= 'XML' ) | (enumLiteral_15= 'Binary' ) ) )
            // InternalRsl.g:4409:2: ( (enumLiteral_0= 'Integer' ) | (enumLiteral_1= 'Double' ) | (enumLiteral_2= 'Decimal' ) | (enumLiteral_3= 'Boolean' ) | (enumLiteral_4= 'Bit' ) | (enumLiteral_5= 'Currency' ) | (enumLiteral_6= 'Date' ) | (enumLiteral_7= 'Time' ) | (enumLiteral_8= 'Datetime' ) | (enumLiteral_9= 'String' ) | (enumLiteral_10= 'Text' ) | (enumLiteral_11= 'Regex' ) | (enumLiteral_12= 'URL' ) | (enumLiteral_13= 'Image' ) | (enumLiteral_14= 'XML' ) | (enumLiteral_15= 'Binary' ) )
            {
            // InternalRsl.g:4409:2: ( (enumLiteral_0= 'Integer' ) | (enumLiteral_1= 'Double' ) | (enumLiteral_2= 'Decimal' ) | (enumLiteral_3= 'Boolean' ) | (enumLiteral_4= 'Bit' ) | (enumLiteral_5= 'Currency' ) | (enumLiteral_6= 'Date' ) | (enumLiteral_7= 'Time' ) | (enumLiteral_8= 'Datetime' ) | (enumLiteral_9= 'String' ) | (enumLiteral_10= 'Text' ) | (enumLiteral_11= 'Regex' ) | (enumLiteral_12= 'URL' ) | (enumLiteral_13= 'Image' ) | (enumLiteral_14= 'XML' ) | (enumLiteral_15= 'Binary' ) )
            int alt88=16;
            switch ( input.LA(1) ) {
            case 111:
                {
                alt88=1;
                }
                break;
            case 112:
                {
                alt88=2;
                }
                break;
            case 113:
                {
                alt88=3;
                }
                break;
            case 114:
                {
                alt88=4;
                }
                break;
            case 115:
                {
                alt88=5;
                }
                break;
            case 116:
                {
                alt88=6;
                }
                break;
            case 117:
                {
                alt88=7;
                }
                break;
            case 118:
                {
                alt88=8;
                }
                break;
            case 119:
                {
                alt88=9;
                }
                break;
            case 120:
                {
                alt88=10;
                }
                break;
            case 121:
                {
                alt88=11;
                }
                break;
            case 122:
                {
                alt88=12;
                }
                break;
            case 123:
                {
                alt88=13;
                }
                break;
            case 124:
                {
                alt88=14;
                }
                break;
            case 125:
                {
                alt88=15;
                }
                break;
            case 126:
                {
                alt88=16;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 88, 0, input);

                throw nvae;
            }

            switch (alt88) {
                case 1 :
                    // InternalRsl.g:4410:3: (enumLiteral_0= 'Integer' )
                    {
                    // InternalRsl.g:4410:3: (enumLiteral_0= 'Integer' )
                    // InternalRsl.g:4411:4: enumLiteral_0= 'Integer'
                    {
                    enumLiteral_0=(Token)match(input,111,FOLLOW_2); 

                    				current = grammarAccess.getAttributeTypeAccess().getIntegerEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getAttributeTypeAccess().getIntegerEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalRsl.g:4418:3: (enumLiteral_1= 'Double' )
                    {
                    // InternalRsl.g:4418:3: (enumLiteral_1= 'Double' )
                    // InternalRsl.g:4419:4: enumLiteral_1= 'Double'
                    {
                    enumLiteral_1=(Token)match(input,112,FOLLOW_2); 

                    				current = grammarAccess.getAttributeTypeAccess().getDoubleEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getAttributeTypeAccess().getDoubleEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalRsl.g:4426:3: (enumLiteral_2= 'Decimal' )
                    {
                    // InternalRsl.g:4426:3: (enumLiteral_2= 'Decimal' )
                    // InternalRsl.g:4427:4: enumLiteral_2= 'Decimal'
                    {
                    enumLiteral_2=(Token)match(input,113,FOLLOW_2); 

                    				current = grammarAccess.getAttributeTypeAccess().getDecimalEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getAttributeTypeAccess().getDecimalEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalRsl.g:4434:3: (enumLiteral_3= 'Boolean' )
                    {
                    // InternalRsl.g:4434:3: (enumLiteral_3= 'Boolean' )
                    // InternalRsl.g:4435:4: enumLiteral_3= 'Boolean'
                    {
                    enumLiteral_3=(Token)match(input,114,FOLLOW_2); 

                    				current = grammarAccess.getAttributeTypeAccess().getBooleanEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getAttributeTypeAccess().getBooleanEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalRsl.g:4442:3: (enumLiteral_4= 'Bit' )
                    {
                    // InternalRsl.g:4442:3: (enumLiteral_4= 'Bit' )
                    // InternalRsl.g:4443:4: enumLiteral_4= 'Bit'
                    {
                    enumLiteral_4=(Token)match(input,115,FOLLOW_2); 

                    				current = grammarAccess.getAttributeTypeAccess().getBitEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getAttributeTypeAccess().getBitEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalRsl.g:4450:3: (enumLiteral_5= 'Currency' )
                    {
                    // InternalRsl.g:4450:3: (enumLiteral_5= 'Currency' )
                    // InternalRsl.g:4451:4: enumLiteral_5= 'Currency'
                    {
                    enumLiteral_5=(Token)match(input,116,FOLLOW_2); 

                    				current = grammarAccess.getAttributeTypeAccess().getCurrencyEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getAttributeTypeAccess().getCurrencyEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalRsl.g:4458:3: (enumLiteral_6= 'Date' )
                    {
                    // InternalRsl.g:4458:3: (enumLiteral_6= 'Date' )
                    // InternalRsl.g:4459:4: enumLiteral_6= 'Date'
                    {
                    enumLiteral_6=(Token)match(input,117,FOLLOW_2); 

                    				current = grammarAccess.getAttributeTypeAccess().getDateEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getAttributeTypeAccess().getDateEnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalRsl.g:4466:3: (enumLiteral_7= 'Time' )
                    {
                    // InternalRsl.g:4466:3: (enumLiteral_7= 'Time' )
                    // InternalRsl.g:4467:4: enumLiteral_7= 'Time'
                    {
                    enumLiteral_7=(Token)match(input,118,FOLLOW_2); 

                    				current = grammarAccess.getAttributeTypeAccess().getTimeEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_7, grammarAccess.getAttributeTypeAccess().getTimeEnumLiteralDeclaration_7());
                    			

                    }


                    }
                    break;
                case 9 :
                    // InternalRsl.g:4474:3: (enumLiteral_8= 'Datetime' )
                    {
                    // InternalRsl.g:4474:3: (enumLiteral_8= 'Datetime' )
                    // InternalRsl.g:4475:4: enumLiteral_8= 'Datetime'
                    {
                    enumLiteral_8=(Token)match(input,119,FOLLOW_2); 

                    				current = grammarAccess.getAttributeTypeAccess().getDatetimeEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_8, grammarAccess.getAttributeTypeAccess().getDatetimeEnumLiteralDeclaration_8());
                    			

                    }


                    }
                    break;
                case 10 :
                    // InternalRsl.g:4482:3: (enumLiteral_9= 'String' )
                    {
                    // InternalRsl.g:4482:3: (enumLiteral_9= 'String' )
                    // InternalRsl.g:4483:4: enumLiteral_9= 'String'
                    {
                    enumLiteral_9=(Token)match(input,120,FOLLOW_2); 

                    				current = grammarAccess.getAttributeTypeAccess().getStringEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_9, grammarAccess.getAttributeTypeAccess().getStringEnumLiteralDeclaration_9());
                    			

                    }


                    }
                    break;
                case 11 :
                    // InternalRsl.g:4490:3: (enumLiteral_10= 'Text' )
                    {
                    // InternalRsl.g:4490:3: (enumLiteral_10= 'Text' )
                    // InternalRsl.g:4491:4: enumLiteral_10= 'Text'
                    {
                    enumLiteral_10=(Token)match(input,121,FOLLOW_2); 

                    				current = grammarAccess.getAttributeTypeAccess().getTextEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_10, grammarAccess.getAttributeTypeAccess().getTextEnumLiteralDeclaration_10());
                    			

                    }


                    }
                    break;
                case 12 :
                    // InternalRsl.g:4498:3: (enumLiteral_11= 'Regex' )
                    {
                    // InternalRsl.g:4498:3: (enumLiteral_11= 'Regex' )
                    // InternalRsl.g:4499:4: enumLiteral_11= 'Regex'
                    {
                    enumLiteral_11=(Token)match(input,122,FOLLOW_2); 

                    				current = grammarAccess.getAttributeTypeAccess().getRegexEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_11, grammarAccess.getAttributeTypeAccess().getRegexEnumLiteralDeclaration_11());
                    			

                    }


                    }
                    break;
                case 13 :
                    // InternalRsl.g:4506:3: (enumLiteral_12= 'URL' )
                    {
                    // InternalRsl.g:4506:3: (enumLiteral_12= 'URL' )
                    // InternalRsl.g:4507:4: enumLiteral_12= 'URL'
                    {
                    enumLiteral_12=(Token)match(input,123,FOLLOW_2); 

                    				current = grammarAccess.getAttributeTypeAccess().getURLEnumLiteralDeclaration_12().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_12, grammarAccess.getAttributeTypeAccess().getURLEnumLiteralDeclaration_12());
                    			

                    }


                    }
                    break;
                case 14 :
                    // InternalRsl.g:4514:3: (enumLiteral_13= 'Image' )
                    {
                    // InternalRsl.g:4514:3: (enumLiteral_13= 'Image' )
                    // InternalRsl.g:4515:4: enumLiteral_13= 'Image'
                    {
                    enumLiteral_13=(Token)match(input,124,FOLLOW_2); 

                    				current = grammarAccess.getAttributeTypeAccess().getImageEnumLiteralDeclaration_13().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_13, grammarAccess.getAttributeTypeAccess().getImageEnumLiteralDeclaration_13());
                    			

                    }


                    }
                    break;
                case 15 :
                    // InternalRsl.g:4522:3: (enumLiteral_14= 'XML' )
                    {
                    // InternalRsl.g:4522:3: (enumLiteral_14= 'XML' )
                    // InternalRsl.g:4523:4: enumLiteral_14= 'XML'
                    {
                    enumLiteral_14=(Token)match(input,125,FOLLOW_2); 

                    				current = grammarAccess.getAttributeTypeAccess().getXMLEnumLiteralDeclaration_14().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_14, grammarAccess.getAttributeTypeAccess().getXMLEnumLiteralDeclaration_14());
                    			

                    }


                    }
                    break;
                case 16 :
                    // InternalRsl.g:4530:3: (enumLiteral_15= 'Binary' )
                    {
                    // InternalRsl.g:4530:3: (enumLiteral_15= 'Binary' )
                    // InternalRsl.g:4531:4: enumLiteral_15= 'Binary'
                    {
                    enumLiteral_15=(Token)match(input,126,FOLLOW_2); 

                    				current = grammarAccess.getAttributeTypeAccess().getBinaryEnumLiteralDeclaration_15().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_15, grammarAccess.getAttributeTypeAccess().getBinaryEnumLiteralDeclaration_15());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAttributeType"


    // $ANTLR start "ruleDataEntityViewType"
    // InternalRsl.g:4541:1: ruleDataEntityViewType returns [Enumerator current=null] : ( (enumLiteral_0= 'VerySimple' ) | (enumLiteral_1= 'Simple' ) | (enumLiteral_2= 'Complex' ) ) ;
    public final Enumerator ruleDataEntityViewType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalRsl.g:4547:2: ( ( (enumLiteral_0= 'VerySimple' ) | (enumLiteral_1= 'Simple' ) | (enumLiteral_2= 'Complex' ) ) )
            // InternalRsl.g:4548:2: ( (enumLiteral_0= 'VerySimple' ) | (enumLiteral_1= 'Simple' ) | (enumLiteral_2= 'Complex' ) )
            {
            // InternalRsl.g:4548:2: ( (enumLiteral_0= 'VerySimple' ) | (enumLiteral_1= 'Simple' ) | (enumLiteral_2= 'Complex' ) )
            int alt89=3;
            switch ( input.LA(1) ) {
            case 127:
                {
                alt89=1;
                }
                break;
            case 109:
                {
                alt89=2;
                }
                break;
            case 110:
                {
                alt89=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 89, 0, input);

                throw nvae;
            }

            switch (alt89) {
                case 1 :
                    // InternalRsl.g:4549:3: (enumLiteral_0= 'VerySimple' )
                    {
                    // InternalRsl.g:4549:3: (enumLiteral_0= 'VerySimple' )
                    // InternalRsl.g:4550:4: enumLiteral_0= 'VerySimple'
                    {
                    enumLiteral_0=(Token)match(input,127,FOLLOW_2); 

                    				current = grammarAccess.getDataEntityViewTypeAccess().getVerySimpleEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getDataEntityViewTypeAccess().getVerySimpleEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalRsl.g:4557:3: (enumLiteral_1= 'Simple' )
                    {
                    // InternalRsl.g:4557:3: (enumLiteral_1= 'Simple' )
                    // InternalRsl.g:4558:4: enumLiteral_1= 'Simple'
                    {
                    enumLiteral_1=(Token)match(input,109,FOLLOW_2); 

                    				current = grammarAccess.getDataEntityViewTypeAccess().getSimpleEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getDataEntityViewTypeAccess().getSimpleEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalRsl.g:4565:3: (enumLiteral_2= 'Complex' )
                    {
                    // InternalRsl.g:4565:3: (enumLiteral_2= 'Complex' )
                    // InternalRsl.g:4566:4: enumLiteral_2= 'Complex'
                    {
                    enumLiteral_2=(Token)match(input,110,FOLLOW_2); 

                    				current = grammarAccess.getDataEntityViewTypeAccess().getComplexEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getDataEntityViewTypeAccess().getComplexEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDataEntityViewType"


    // $ANTLR start "ruleActorType"
    // InternalRsl.g:4576:1: ruleActorType returns [Enumerator current=null] : ( (enumLiteral_0= 'User' ) | (enumLiteral_1= 'ExternalSystem' ) | (enumLiteral_2= 'Timer' ) ) ;
    public final Enumerator ruleActorType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalRsl.g:4582:2: ( ( (enumLiteral_0= 'User' ) | (enumLiteral_1= 'ExternalSystem' ) | (enumLiteral_2= 'Timer' ) ) )
            // InternalRsl.g:4583:2: ( (enumLiteral_0= 'User' ) | (enumLiteral_1= 'ExternalSystem' ) | (enumLiteral_2= 'Timer' ) )
            {
            // InternalRsl.g:4583:2: ( (enumLiteral_0= 'User' ) | (enumLiteral_1= 'ExternalSystem' ) | (enumLiteral_2= 'Timer' ) )
            int alt90=3;
            switch ( input.LA(1) ) {
            case 128:
                {
                alt90=1;
                }
                break;
            case 129:
                {
                alt90=2;
                }
                break;
            case 130:
                {
                alt90=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 90, 0, input);

                throw nvae;
            }

            switch (alt90) {
                case 1 :
                    // InternalRsl.g:4584:3: (enumLiteral_0= 'User' )
                    {
                    // InternalRsl.g:4584:3: (enumLiteral_0= 'User' )
                    // InternalRsl.g:4585:4: enumLiteral_0= 'User'
                    {
                    enumLiteral_0=(Token)match(input,128,FOLLOW_2); 

                    				current = grammarAccess.getActorTypeAccess().getUserEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getActorTypeAccess().getUserEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalRsl.g:4592:3: (enumLiteral_1= 'ExternalSystem' )
                    {
                    // InternalRsl.g:4592:3: (enumLiteral_1= 'ExternalSystem' )
                    // InternalRsl.g:4593:4: enumLiteral_1= 'ExternalSystem'
                    {
                    enumLiteral_1=(Token)match(input,129,FOLLOW_2); 

                    				current = grammarAccess.getActorTypeAccess().getExternalSystemEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getActorTypeAccess().getExternalSystemEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalRsl.g:4600:3: (enumLiteral_2= 'Timer' )
                    {
                    // InternalRsl.g:4600:3: (enumLiteral_2= 'Timer' )
                    // InternalRsl.g:4601:4: enumLiteral_2= 'Timer'
                    {
                    enumLiteral_2=(Token)match(input,130,FOLLOW_2); 

                    				current = grammarAccess.getActorTypeAccess().getTimerEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getActorTypeAccess().getTimerEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleActorType"


    // $ANTLR start "rulePriorityType"
    // InternalRsl.g:4611:1: rulePriorityType returns [Enumerator current=null] : ( (enumLiteral_0= 'Must' ) | (enumLiteral_1= 'Should' ) | (enumLiteral_2= 'Could' ) | (enumLiteral_3= 'WillNot' ) ) ;
    public final Enumerator rulePriorityType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalRsl.g:4617:2: ( ( (enumLiteral_0= 'Must' ) | (enumLiteral_1= 'Should' ) | (enumLiteral_2= 'Could' ) | (enumLiteral_3= 'WillNot' ) ) )
            // InternalRsl.g:4618:2: ( (enumLiteral_0= 'Must' ) | (enumLiteral_1= 'Should' ) | (enumLiteral_2= 'Could' ) | (enumLiteral_3= 'WillNot' ) )
            {
            // InternalRsl.g:4618:2: ( (enumLiteral_0= 'Must' ) | (enumLiteral_1= 'Should' ) | (enumLiteral_2= 'Could' ) | (enumLiteral_3= 'WillNot' ) )
            int alt91=4;
            switch ( input.LA(1) ) {
            case 131:
                {
                alt91=1;
                }
                break;
            case 132:
                {
                alt91=2;
                }
                break;
            case 133:
                {
                alt91=3;
                }
                break;
            case 134:
                {
                alt91=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 91, 0, input);

                throw nvae;
            }

            switch (alt91) {
                case 1 :
                    // InternalRsl.g:4619:3: (enumLiteral_0= 'Must' )
                    {
                    // InternalRsl.g:4619:3: (enumLiteral_0= 'Must' )
                    // InternalRsl.g:4620:4: enumLiteral_0= 'Must'
                    {
                    enumLiteral_0=(Token)match(input,131,FOLLOW_2); 

                    				current = grammarAccess.getPriorityTypeAccess().getMustEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getPriorityTypeAccess().getMustEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalRsl.g:4627:3: (enumLiteral_1= 'Should' )
                    {
                    // InternalRsl.g:4627:3: (enumLiteral_1= 'Should' )
                    // InternalRsl.g:4628:4: enumLiteral_1= 'Should'
                    {
                    enumLiteral_1=(Token)match(input,132,FOLLOW_2); 

                    				current = grammarAccess.getPriorityTypeAccess().getShouldEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getPriorityTypeAccess().getShouldEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalRsl.g:4635:3: (enumLiteral_2= 'Could' )
                    {
                    // InternalRsl.g:4635:3: (enumLiteral_2= 'Could' )
                    // InternalRsl.g:4636:4: enumLiteral_2= 'Could'
                    {
                    enumLiteral_2=(Token)match(input,133,FOLLOW_2); 

                    				current = grammarAccess.getPriorityTypeAccess().getCouldEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getPriorityTypeAccess().getCouldEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalRsl.g:4643:3: (enumLiteral_3= 'WillNot' )
                    {
                    // InternalRsl.g:4643:3: (enumLiteral_3= 'WillNot' )
                    // InternalRsl.g:4644:4: enumLiteral_3= 'WillNot'
                    {
                    enumLiteral_3=(Token)match(input,134,FOLLOW_2); 

                    				current = grammarAccess.getPriorityTypeAccess().getWillNotEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getPriorityTypeAccess().getWillNotEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePriorityType"


    // $ANTLR start "ruleRequirementRelationType"
    // InternalRsl.g:4654:1: ruleRequirementRelationType returns [Enumerator current=null] : ( (enumLiteral_0= 'Requires' ) | (enumLiteral_1= 'Supports' ) | (enumLiteral_2= 'Obstructs' ) | (enumLiteral_3= 'Conflicts' ) | (enumLiteral_4= 'Identical' ) | (enumLiteral_5= 'Relates' ) | (enumLiteral_6= 'Other' ) ) ;
    public final Enumerator ruleRequirementRelationType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;


        	enterRule();

        try {
            // InternalRsl.g:4660:2: ( ( (enumLiteral_0= 'Requires' ) | (enumLiteral_1= 'Supports' ) | (enumLiteral_2= 'Obstructs' ) | (enumLiteral_3= 'Conflicts' ) | (enumLiteral_4= 'Identical' ) | (enumLiteral_5= 'Relates' ) | (enumLiteral_6= 'Other' ) ) )
            // InternalRsl.g:4661:2: ( (enumLiteral_0= 'Requires' ) | (enumLiteral_1= 'Supports' ) | (enumLiteral_2= 'Obstructs' ) | (enumLiteral_3= 'Conflicts' ) | (enumLiteral_4= 'Identical' ) | (enumLiteral_5= 'Relates' ) | (enumLiteral_6= 'Other' ) )
            {
            // InternalRsl.g:4661:2: ( (enumLiteral_0= 'Requires' ) | (enumLiteral_1= 'Supports' ) | (enumLiteral_2= 'Obstructs' ) | (enumLiteral_3= 'Conflicts' ) | (enumLiteral_4= 'Identical' ) | (enumLiteral_5= 'Relates' ) | (enumLiteral_6= 'Other' ) )
            int alt92=7;
            switch ( input.LA(1) ) {
            case 96:
                {
                alt92=1;
                }
                break;
            case 97:
                {
                alt92=2;
                }
                break;
            case 98:
                {
                alt92=3;
                }
                break;
            case 99:
                {
                alt92=4;
                }
                break;
            case 100:
                {
                alt92=5;
                }
                break;
            case 101:
                {
                alt92=6;
                }
                break;
            case 93:
                {
                alt92=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 92, 0, input);

                throw nvae;
            }

            switch (alt92) {
                case 1 :
                    // InternalRsl.g:4662:3: (enumLiteral_0= 'Requires' )
                    {
                    // InternalRsl.g:4662:3: (enumLiteral_0= 'Requires' )
                    // InternalRsl.g:4663:4: enumLiteral_0= 'Requires'
                    {
                    enumLiteral_0=(Token)match(input,96,FOLLOW_2); 

                    				current = grammarAccess.getRequirementRelationTypeAccess().getRequiresEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getRequirementRelationTypeAccess().getRequiresEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalRsl.g:4670:3: (enumLiteral_1= 'Supports' )
                    {
                    // InternalRsl.g:4670:3: (enumLiteral_1= 'Supports' )
                    // InternalRsl.g:4671:4: enumLiteral_1= 'Supports'
                    {
                    enumLiteral_1=(Token)match(input,97,FOLLOW_2); 

                    				current = grammarAccess.getRequirementRelationTypeAccess().getSupportsEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getRequirementRelationTypeAccess().getSupportsEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalRsl.g:4678:3: (enumLiteral_2= 'Obstructs' )
                    {
                    // InternalRsl.g:4678:3: (enumLiteral_2= 'Obstructs' )
                    // InternalRsl.g:4679:4: enumLiteral_2= 'Obstructs'
                    {
                    enumLiteral_2=(Token)match(input,98,FOLLOW_2); 

                    				current = grammarAccess.getRequirementRelationTypeAccess().getObstructsEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getRequirementRelationTypeAccess().getObstructsEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalRsl.g:4686:3: (enumLiteral_3= 'Conflicts' )
                    {
                    // InternalRsl.g:4686:3: (enumLiteral_3= 'Conflicts' )
                    // InternalRsl.g:4687:4: enumLiteral_3= 'Conflicts'
                    {
                    enumLiteral_3=(Token)match(input,99,FOLLOW_2); 

                    				current = grammarAccess.getRequirementRelationTypeAccess().getConflictsEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getRequirementRelationTypeAccess().getConflictsEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalRsl.g:4694:3: (enumLiteral_4= 'Identical' )
                    {
                    // InternalRsl.g:4694:3: (enumLiteral_4= 'Identical' )
                    // InternalRsl.g:4695:4: enumLiteral_4= 'Identical'
                    {
                    enumLiteral_4=(Token)match(input,100,FOLLOW_2); 

                    				current = grammarAccess.getRequirementRelationTypeAccess().getIdenticalEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getRequirementRelationTypeAccess().getIdenticalEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalRsl.g:4702:3: (enumLiteral_5= 'Relates' )
                    {
                    // InternalRsl.g:4702:3: (enumLiteral_5= 'Relates' )
                    // InternalRsl.g:4703:4: enumLiteral_5= 'Relates'
                    {
                    enumLiteral_5=(Token)match(input,101,FOLLOW_2); 

                    				current = grammarAccess.getRequirementRelationTypeAccess().getRelatesEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getRequirementRelationTypeAccess().getRelatesEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalRsl.g:4710:3: (enumLiteral_6= 'Other' )
                    {
                    // InternalRsl.g:4710:3: (enumLiteral_6= 'Other' )
                    // InternalRsl.g:4711:4: enumLiteral_6= 'Other'
                    {
                    enumLiteral_6=(Token)match(input,93,FOLLOW_2); 

                    				current = grammarAccess.getRequirementRelationTypeAccess().getOtherEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getRequirementRelationTypeAccess().getOtherEnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRequirementRelationType"


    // $ANTLR start "ruleUseCaseType"
    // InternalRsl.g:4721:1: ruleUseCaseType returns [Enumerator current=null] : ( (enumLiteral_0= 'EntityCreate' ) | (enumLiteral_1= 'EntityRead' ) | (enumLiteral_2= 'EntityUpdate' ) | (enumLiteral_3= 'EntityDelete' ) | (enumLiteral_4= 'EntityReport' ) | (enumLiteral_5= 'EntityDashboard' ) | (enumLiteral_6= 'EntityOther' ) | (enumLiteral_7= 'EntitiesManage' ) | (enumLiteral_8= 'EntitiesBrowse' ) | (enumLiteral_9= 'EntitiesSearch' ) | (enumLiteral_10= 'EntitiesReport' ) | (enumLiteral_11= 'EntitiesDashboard' ) | (enumLiteral_12= 'EntitiesInteropImport' ) | (enumLiteral_13= 'EntitiesInteropExport' ) | (enumLiteral_14= 'EntitiesInteropSync' ) | (enumLiteral_15= 'EntitiesInteropSendMessage' ) | (enumLiteral_16= 'EntitiesInteropServiceInvocation' ) | (enumLiteral_17= 'EntitiesMapShow' ) | (enumLiteral_18= 'EntitiesMapInteract' ) | (enumLiteral_19= 'EntitiesOther' ) | (enumLiteral_20= 'Other' ) ) ;
    public final Enumerator ruleUseCaseType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;
        Token enumLiteral_8=null;
        Token enumLiteral_9=null;
        Token enumLiteral_10=null;
        Token enumLiteral_11=null;
        Token enumLiteral_12=null;
        Token enumLiteral_13=null;
        Token enumLiteral_14=null;
        Token enumLiteral_15=null;
        Token enumLiteral_16=null;
        Token enumLiteral_17=null;
        Token enumLiteral_18=null;
        Token enumLiteral_19=null;
        Token enumLiteral_20=null;


        	enterRule();

        try {
            // InternalRsl.g:4727:2: ( ( (enumLiteral_0= 'EntityCreate' ) | (enumLiteral_1= 'EntityRead' ) | (enumLiteral_2= 'EntityUpdate' ) | (enumLiteral_3= 'EntityDelete' ) | (enumLiteral_4= 'EntityReport' ) | (enumLiteral_5= 'EntityDashboard' ) | (enumLiteral_6= 'EntityOther' ) | (enumLiteral_7= 'EntitiesManage' ) | (enumLiteral_8= 'EntitiesBrowse' ) | (enumLiteral_9= 'EntitiesSearch' ) | (enumLiteral_10= 'EntitiesReport' ) | (enumLiteral_11= 'EntitiesDashboard' ) | (enumLiteral_12= 'EntitiesInteropImport' ) | (enumLiteral_13= 'EntitiesInteropExport' ) | (enumLiteral_14= 'EntitiesInteropSync' ) | (enumLiteral_15= 'EntitiesInteropSendMessage' ) | (enumLiteral_16= 'EntitiesInteropServiceInvocation' ) | (enumLiteral_17= 'EntitiesMapShow' ) | (enumLiteral_18= 'EntitiesMapInteract' ) | (enumLiteral_19= 'EntitiesOther' ) | (enumLiteral_20= 'Other' ) ) )
            // InternalRsl.g:4728:2: ( (enumLiteral_0= 'EntityCreate' ) | (enumLiteral_1= 'EntityRead' ) | (enumLiteral_2= 'EntityUpdate' ) | (enumLiteral_3= 'EntityDelete' ) | (enumLiteral_4= 'EntityReport' ) | (enumLiteral_5= 'EntityDashboard' ) | (enumLiteral_6= 'EntityOther' ) | (enumLiteral_7= 'EntitiesManage' ) | (enumLiteral_8= 'EntitiesBrowse' ) | (enumLiteral_9= 'EntitiesSearch' ) | (enumLiteral_10= 'EntitiesReport' ) | (enumLiteral_11= 'EntitiesDashboard' ) | (enumLiteral_12= 'EntitiesInteropImport' ) | (enumLiteral_13= 'EntitiesInteropExport' ) | (enumLiteral_14= 'EntitiesInteropSync' ) | (enumLiteral_15= 'EntitiesInteropSendMessage' ) | (enumLiteral_16= 'EntitiesInteropServiceInvocation' ) | (enumLiteral_17= 'EntitiesMapShow' ) | (enumLiteral_18= 'EntitiesMapInteract' ) | (enumLiteral_19= 'EntitiesOther' ) | (enumLiteral_20= 'Other' ) )
            {
            // InternalRsl.g:4728:2: ( (enumLiteral_0= 'EntityCreate' ) | (enumLiteral_1= 'EntityRead' ) | (enumLiteral_2= 'EntityUpdate' ) | (enumLiteral_3= 'EntityDelete' ) | (enumLiteral_4= 'EntityReport' ) | (enumLiteral_5= 'EntityDashboard' ) | (enumLiteral_6= 'EntityOther' ) | (enumLiteral_7= 'EntitiesManage' ) | (enumLiteral_8= 'EntitiesBrowse' ) | (enumLiteral_9= 'EntitiesSearch' ) | (enumLiteral_10= 'EntitiesReport' ) | (enumLiteral_11= 'EntitiesDashboard' ) | (enumLiteral_12= 'EntitiesInteropImport' ) | (enumLiteral_13= 'EntitiesInteropExport' ) | (enumLiteral_14= 'EntitiesInteropSync' ) | (enumLiteral_15= 'EntitiesInteropSendMessage' ) | (enumLiteral_16= 'EntitiesInteropServiceInvocation' ) | (enumLiteral_17= 'EntitiesMapShow' ) | (enumLiteral_18= 'EntitiesMapInteract' ) | (enumLiteral_19= 'EntitiesOther' ) | (enumLiteral_20= 'Other' ) )
            int alt93=21;
            switch ( input.LA(1) ) {
            case 135:
                {
                alt93=1;
                }
                break;
            case 136:
                {
                alt93=2;
                }
                break;
            case 137:
                {
                alt93=3;
                }
                break;
            case 138:
                {
                alt93=4;
                }
                break;
            case 139:
                {
                alt93=5;
                }
                break;
            case 140:
                {
                alt93=6;
                }
                break;
            case 141:
                {
                alt93=7;
                }
                break;
            case 142:
                {
                alt93=8;
                }
                break;
            case 143:
                {
                alt93=9;
                }
                break;
            case 144:
                {
                alt93=10;
                }
                break;
            case 145:
                {
                alt93=11;
                }
                break;
            case 146:
                {
                alt93=12;
                }
                break;
            case 147:
                {
                alt93=13;
                }
                break;
            case 148:
                {
                alt93=14;
                }
                break;
            case 149:
                {
                alt93=15;
                }
                break;
            case 150:
                {
                alt93=16;
                }
                break;
            case 151:
                {
                alt93=17;
                }
                break;
            case 152:
                {
                alt93=18;
                }
                break;
            case 153:
                {
                alt93=19;
                }
                break;
            case 154:
                {
                alt93=20;
                }
                break;
            case 93:
                {
                alt93=21;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 93, 0, input);

                throw nvae;
            }

            switch (alt93) {
                case 1 :
                    // InternalRsl.g:4729:3: (enumLiteral_0= 'EntityCreate' )
                    {
                    // InternalRsl.g:4729:3: (enumLiteral_0= 'EntityCreate' )
                    // InternalRsl.g:4730:4: enumLiteral_0= 'EntityCreate'
                    {
                    enumLiteral_0=(Token)match(input,135,FOLLOW_2); 

                    				current = grammarAccess.getUseCaseTypeAccess().getEntityCreateEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getUseCaseTypeAccess().getEntityCreateEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalRsl.g:4737:3: (enumLiteral_1= 'EntityRead' )
                    {
                    // InternalRsl.g:4737:3: (enumLiteral_1= 'EntityRead' )
                    // InternalRsl.g:4738:4: enumLiteral_1= 'EntityRead'
                    {
                    enumLiteral_1=(Token)match(input,136,FOLLOW_2); 

                    				current = grammarAccess.getUseCaseTypeAccess().getEntityReadEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getUseCaseTypeAccess().getEntityReadEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalRsl.g:4745:3: (enumLiteral_2= 'EntityUpdate' )
                    {
                    // InternalRsl.g:4745:3: (enumLiteral_2= 'EntityUpdate' )
                    // InternalRsl.g:4746:4: enumLiteral_2= 'EntityUpdate'
                    {
                    enumLiteral_2=(Token)match(input,137,FOLLOW_2); 

                    				current = grammarAccess.getUseCaseTypeAccess().getEntityUpdateEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getUseCaseTypeAccess().getEntityUpdateEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalRsl.g:4753:3: (enumLiteral_3= 'EntityDelete' )
                    {
                    // InternalRsl.g:4753:3: (enumLiteral_3= 'EntityDelete' )
                    // InternalRsl.g:4754:4: enumLiteral_3= 'EntityDelete'
                    {
                    enumLiteral_3=(Token)match(input,138,FOLLOW_2); 

                    				current = grammarAccess.getUseCaseTypeAccess().getEntityDeleteEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getUseCaseTypeAccess().getEntityDeleteEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalRsl.g:4761:3: (enumLiteral_4= 'EntityReport' )
                    {
                    // InternalRsl.g:4761:3: (enumLiteral_4= 'EntityReport' )
                    // InternalRsl.g:4762:4: enumLiteral_4= 'EntityReport'
                    {
                    enumLiteral_4=(Token)match(input,139,FOLLOW_2); 

                    				current = grammarAccess.getUseCaseTypeAccess().getEntityReportEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getUseCaseTypeAccess().getEntityReportEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalRsl.g:4769:3: (enumLiteral_5= 'EntityDashboard' )
                    {
                    // InternalRsl.g:4769:3: (enumLiteral_5= 'EntityDashboard' )
                    // InternalRsl.g:4770:4: enumLiteral_5= 'EntityDashboard'
                    {
                    enumLiteral_5=(Token)match(input,140,FOLLOW_2); 

                    				current = grammarAccess.getUseCaseTypeAccess().getEntityDashboardEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getUseCaseTypeAccess().getEntityDashboardEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalRsl.g:4777:3: (enumLiteral_6= 'EntityOther' )
                    {
                    // InternalRsl.g:4777:3: (enumLiteral_6= 'EntityOther' )
                    // InternalRsl.g:4778:4: enumLiteral_6= 'EntityOther'
                    {
                    enumLiteral_6=(Token)match(input,141,FOLLOW_2); 

                    				current = grammarAccess.getUseCaseTypeAccess().getEntityOtherEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getUseCaseTypeAccess().getEntityOtherEnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalRsl.g:4785:3: (enumLiteral_7= 'EntitiesManage' )
                    {
                    // InternalRsl.g:4785:3: (enumLiteral_7= 'EntitiesManage' )
                    // InternalRsl.g:4786:4: enumLiteral_7= 'EntitiesManage'
                    {
                    enumLiteral_7=(Token)match(input,142,FOLLOW_2); 

                    				current = grammarAccess.getUseCaseTypeAccess().getEntitiesManageEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_7, grammarAccess.getUseCaseTypeAccess().getEntitiesManageEnumLiteralDeclaration_7());
                    			

                    }


                    }
                    break;
                case 9 :
                    // InternalRsl.g:4793:3: (enumLiteral_8= 'EntitiesBrowse' )
                    {
                    // InternalRsl.g:4793:3: (enumLiteral_8= 'EntitiesBrowse' )
                    // InternalRsl.g:4794:4: enumLiteral_8= 'EntitiesBrowse'
                    {
                    enumLiteral_8=(Token)match(input,143,FOLLOW_2); 

                    				current = grammarAccess.getUseCaseTypeAccess().getEntitiesBrowseEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_8, grammarAccess.getUseCaseTypeAccess().getEntitiesBrowseEnumLiteralDeclaration_8());
                    			

                    }


                    }
                    break;
                case 10 :
                    // InternalRsl.g:4801:3: (enumLiteral_9= 'EntitiesSearch' )
                    {
                    // InternalRsl.g:4801:3: (enumLiteral_9= 'EntitiesSearch' )
                    // InternalRsl.g:4802:4: enumLiteral_9= 'EntitiesSearch'
                    {
                    enumLiteral_9=(Token)match(input,144,FOLLOW_2); 

                    				current = grammarAccess.getUseCaseTypeAccess().getEntitiesSearchEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_9, grammarAccess.getUseCaseTypeAccess().getEntitiesSearchEnumLiteralDeclaration_9());
                    			

                    }


                    }
                    break;
                case 11 :
                    // InternalRsl.g:4809:3: (enumLiteral_10= 'EntitiesReport' )
                    {
                    // InternalRsl.g:4809:3: (enumLiteral_10= 'EntitiesReport' )
                    // InternalRsl.g:4810:4: enumLiteral_10= 'EntitiesReport'
                    {
                    enumLiteral_10=(Token)match(input,145,FOLLOW_2); 

                    				current = grammarAccess.getUseCaseTypeAccess().getEntitiesReportEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_10, grammarAccess.getUseCaseTypeAccess().getEntitiesReportEnumLiteralDeclaration_10());
                    			

                    }


                    }
                    break;
                case 12 :
                    // InternalRsl.g:4817:3: (enumLiteral_11= 'EntitiesDashboard' )
                    {
                    // InternalRsl.g:4817:3: (enumLiteral_11= 'EntitiesDashboard' )
                    // InternalRsl.g:4818:4: enumLiteral_11= 'EntitiesDashboard'
                    {
                    enumLiteral_11=(Token)match(input,146,FOLLOW_2); 

                    				current = grammarAccess.getUseCaseTypeAccess().getEntitiesDashboardEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_11, grammarAccess.getUseCaseTypeAccess().getEntitiesDashboardEnumLiteralDeclaration_11());
                    			

                    }


                    }
                    break;
                case 13 :
                    // InternalRsl.g:4825:3: (enumLiteral_12= 'EntitiesInteropImport' )
                    {
                    // InternalRsl.g:4825:3: (enumLiteral_12= 'EntitiesInteropImport' )
                    // InternalRsl.g:4826:4: enumLiteral_12= 'EntitiesInteropImport'
                    {
                    enumLiteral_12=(Token)match(input,147,FOLLOW_2); 

                    				current = grammarAccess.getUseCaseTypeAccess().getEntitiesInteropImportEnumLiteralDeclaration_12().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_12, grammarAccess.getUseCaseTypeAccess().getEntitiesInteropImportEnumLiteralDeclaration_12());
                    			

                    }


                    }
                    break;
                case 14 :
                    // InternalRsl.g:4833:3: (enumLiteral_13= 'EntitiesInteropExport' )
                    {
                    // InternalRsl.g:4833:3: (enumLiteral_13= 'EntitiesInteropExport' )
                    // InternalRsl.g:4834:4: enumLiteral_13= 'EntitiesInteropExport'
                    {
                    enumLiteral_13=(Token)match(input,148,FOLLOW_2); 

                    				current = grammarAccess.getUseCaseTypeAccess().getEntitiesInteropExportEnumLiteralDeclaration_13().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_13, grammarAccess.getUseCaseTypeAccess().getEntitiesInteropExportEnumLiteralDeclaration_13());
                    			

                    }


                    }
                    break;
                case 15 :
                    // InternalRsl.g:4841:3: (enumLiteral_14= 'EntitiesInteropSync' )
                    {
                    // InternalRsl.g:4841:3: (enumLiteral_14= 'EntitiesInteropSync' )
                    // InternalRsl.g:4842:4: enumLiteral_14= 'EntitiesInteropSync'
                    {
                    enumLiteral_14=(Token)match(input,149,FOLLOW_2); 

                    				current = grammarAccess.getUseCaseTypeAccess().getEntitiesInteropSyncEnumLiteralDeclaration_14().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_14, grammarAccess.getUseCaseTypeAccess().getEntitiesInteropSyncEnumLiteralDeclaration_14());
                    			

                    }


                    }
                    break;
                case 16 :
                    // InternalRsl.g:4849:3: (enumLiteral_15= 'EntitiesInteropSendMessage' )
                    {
                    // InternalRsl.g:4849:3: (enumLiteral_15= 'EntitiesInteropSendMessage' )
                    // InternalRsl.g:4850:4: enumLiteral_15= 'EntitiesInteropSendMessage'
                    {
                    enumLiteral_15=(Token)match(input,150,FOLLOW_2); 

                    				current = grammarAccess.getUseCaseTypeAccess().getEntitiesInteropSendMessageEnumLiteralDeclaration_15().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_15, grammarAccess.getUseCaseTypeAccess().getEntitiesInteropSendMessageEnumLiteralDeclaration_15());
                    			

                    }


                    }
                    break;
                case 17 :
                    // InternalRsl.g:4857:3: (enumLiteral_16= 'EntitiesInteropServiceInvocation' )
                    {
                    // InternalRsl.g:4857:3: (enumLiteral_16= 'EntitiesInteropServiceInvocation' )
                    // InternalRsl.g:4858:4: enumLiteral_16= 'EntitiesInteropServiceInvocation'
                    {
                    enumLiteral_16=(Token)match(input,151,FOLLOW_2); 

                    				current = grammarAccess.getUseCaseTypeAccess().getEntitiesInteropServiceInvocationEnumLiteralDeclaration_16().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_16, grammarAccess.getUseCaseTypeAccess().getEntitiesInteropServiceInvocationEnumLiteralDeclaration_16());
                    			

                    }


                    }
                    break;
                case 18 :
                    // InternalRsl.g:4865:3: (enumLiteral_17= 'EntitiesMapShow' )
                    {
                    // InternalRsl.g:4865:3: (enumLiteral_17= 'EntitiesMapShow' )
                    // InternalRsl.g:4866:4: enumLiteral_17= 'EntitiesMapShow'
                    {
                    enumLiteral_17=(Token)match(input,152,FOLLOW_2); 

                    				current = grammarAccess.getUseCaseTypeAccess().getEntitiesMapShowEnumLiteralDeclaration_17().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_17, grammarAccess.getUseCaseTypeAccess().getEntitiesMapShowEnumLiteralDeclaration_17());
                    			

                    }


                    }
                    break;
                case 19 :
                    // InternalRsl.g:4873:3: (enumLiteral_18= 'EntitiesMapInteract' )
                    {
                    // InternalRsl.g:4873:3: (enumLiteral_18= 'EntitiesMapInteract' )
                    // InternalRsl.g:4874:4: enumLiteral_18= 'EntitiesMapInteract'
                    {
                    enumLiteral_18=(Token)match(input,153,FOLLOW_2); 

                    				current = grammarAccess.getUseCaseTypeAccess().getEntitiesMapInteractEnumLiteralDeclaration_18().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_18, grammarAccess.getUseCaseTypeAccess().getEntitiesMapInteractEnumLiteralDeclaration_18());
                    			

                    }


                    }
                    break;
                case 20 :
                    // InternalRsl.g:4881:3: (enumLiteral_19= 'EntitiesOther' )
                    {
                    // InternalRsl.g:4881:3: (enumLiteral_19= 'EntitiesOther' )
                    // InternalRsl.g:4882:4: enumLiteral_19= 'EntitiesOther'
                    {
                    enumLiteral_19=(Token)match(input,154,FOLLOW_2); 

                    				current = grammarAccess.getUseCaseTypeAccess().getEntitiesOtherEnumLiteralDeclaration_19().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_19, grammarAccess.getUseCaseTypeAccess().getEntitiesOtherEnumLiteralDeclaration_19());
                    			

                    }


                    }
                    break;
                case 21 :
                    // InternalRsl.g:4889:3: (enumLiteral_20= 'Other' )
                    {
                    // InternalRsl.g:4889:3: (enumLiteral_20= 'Other' )
                    // InternalRsl.g:4890:4: enumLiteral_20= 'Other'
                    {
                    enumLiteral_20=(Token)match(input,93,FOLLOW_2); 

                    				current = grammarAccess.getUseCaseTypeAccess().getOtherEnumLiteralDeclaration_20().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_20, grammarAccess.getUseCaseTypeAccess().getOtherEnumLiteralDeclaration_20());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUseCaseType"


    // $ANTLR start "ruleScenarioType"
    // InternalRsl.g:4900:1: ruleScenarioType returns [Enumerator current=null] : ( (enumLiteral_0= 'Main' ) | (enumLiteral_1= 'Alternative' ) | (enumLiteral_2= 'Exception' ) ) ;
    public final Enumerator ruleScenarioType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalRsl.g:4906:2: ( ( (enumLiteral_0= 'Main' ) | (enumLiteral_1= 'Alternative' ) | (enumLiteral_2= 'Exception' ) ) )
            // InternalRsl.g:4907:2: ( (enumLiteral_0= 'Main' ) | (enumLiteral_1= 'Alternative' ) | (enumLiteral_2= 'Exception' ) )
            {
            // InternalRsl.g:4907:2: ( (enumLiteral_0= 'Main' ) | (enumLiteral_1= 'Alternative' ) | (enumLiteral_2= 'Exception' ) )
            int alt94=3;
            switch ( input.LA(1) ) {
            case 155:
                {
                alt94=1;
                }
                break;
            case 156:
                {
                alt94=2;
                }
                break;
            case 157:
                {
                alt94=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 94, 0, input);

                throw nvae;
            }

            switch (alt94) {
                case 1 :
                    // InternalRsl.g:4908:3: (enumLiteral_0= 'Main' )
                    {
                    // InternalRsl.g:4908:3: (enumLiteral_0= 'Main' )
                    // InternalRsl.g:4909:4: enumLiteral_0= 'Main'
                    {
                    enumLiteral_0=(Token)match(input,155,FOLLOW_2); 

                    				current = grammarAccess.getScenarioTypeAccess().getMainEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getScenarioTypeAccess().getMainEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalRsl.g:4916:3: (enumLiteral_1= 'Alternative' )
                    {
                    // InternalRsl.g:4916:3: (enumLiteral_1= 'Alternative' )
                    // InternalRsl.g:4917:4: enumLiteral_1= 'Alternative'
                    {
                    enumLiteral_1=(Token)match(input,156,FOLLOW_2); 

                    				current = grammarAccess.getScenarioTypeAccess().getAlternativeEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getScenarioTypeAccess().getAlternativeEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalRsl.g:4924:3: (enumLiteral_2= 'Exception' )
                    {
                    // InternalRsl.g:4924:3: (enumLiteral_2= 'Exception' )
                    // InternalRsl.g:4925:4: enumLiteral_2= 'Exception'
                    {
                    enumLiteral_2=(Token)match(input,157,FOLLOW_2); 

                    				current = grammarAccess.getScenarioTypeAccess().getExceptionEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getScenarioTypeAccess().getExceptionEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleScenarioType"


    // $ANTLR start "ruleStepOperationType"
    // InternalRsl.g:4935:1: ruleStepOperationType returns [Enumerator current=null] : ( (enumLiteral_0= 'Actor_PrepareData' ) | (enumLiteral_1= 'Actor_CallSystem' ) | (enumLiteral_2= 'System_Executes' ) | (enumLiteral_3= 'System_ReturnResult' ) | (enumLiteral_4= 'Other' ) | (enumLiteral_5= 'None' ) ) ;
    public final Enumerator ruleStepOperationType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;


        	enterRule();

        try {
            // InternalRsl.g:4941:2: ( ( (enumLiteral_0= 'Actor_PrepareData' ) | (enumLiteral_1= 'Actor_CallSystem' ) | (enumLiteral_2= 'System_Executes' ) | (enumLiteral_3= 'System_ReturnResult' ) | (enumLiteral_4= 'Other' ) | (enumLiteral_5= 'None' ) ) )
            // InternalRsl.g:4942:2: ( (enumLiteral_0= 'Actor_PrepareData' ) | (enumLiteral_1= 'Actor_CallSystem' ) | (enumLiteral_2= 'System_Executes' ) | (enumLiteral_3= 'System_ReturnResult' ) | (enumLiteral_4= 'Other' ) | (enumLiteral_5= 'None' ) )
            {
            // InternalRsl.g:4942:2: ( (enumLiteral_0= 'Actor_PrepareData' ) | (enumLiteral_1= 'Actor_CallSystem' ) | (enumLiteral_2= 'System_Executes' ) | (enumLiteral_3= 'System_ReturnResult' ) | (enumLiteral_4= 'Other' ) | (enumLiteral_5= 'None' ) )
            int alt95=6;
            switch ( input.LA(1) ) {
            case 158:
                {
                alt95=1;
                }
                break;
            case 159:
                {
                alt95=2;
                }
                break;
            case 160:
                {
                alt95=3;
                }
                break;
            case 161:
                {
                alt95=4;
                }
                break;
            case 93:
                {
                alt95=5;
                }
                break;
            case 162:
                {
                alt95=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 95, 0, input);

                throw nvae;
            }

            switch (alt95) {
                case 1 :
                    // InternalRsl.g:4943:3: (enumLiteral_0= 'Actor_PrepareData' )
                    {
                    // InternalRsl.g:4943:3: (enumLiteral_0= 'Actor_PrepareData' )
                    // InternalRsl.g:4944:4: enumLiteral_0= 'Actor_PrepareData'
                    {
                    enumLiteral_0=(Token)match(input,158,FOLLOW_2); 

                    				current = grammarAccess.getStepOperationTypeAccess().getActor_PrepareDataEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getStepOperationTypeAccess().getActor_PrepareDataEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalRsl.g:4951:3: (enumLiteral_1= 'Actor_CallSystem' )
                    {
                    // InternalRsl.g:4951:3: (enumLiteral_1= 'Actor_CallSystem' )
                    // InternalRsl.g:4952:4: enumLiteral_1= 'Actor_CallSystem'
                    {
                    enumLiteral_1=(Token)match(input,159,FOLLOW_2); 

                    				current = grammarAccess.getStepOperationTypeAccess().getActor_CallSystemEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getStepOperationTypeAccess().getActor_CallSystemEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalRsl.g:4959:3: (enumLiteral_2= 'System_Executes' )
                    {
                    // InternalRsl.g:4959:3: (enumLiteral_2= 'System_Executes' )
                    // InternalRsl.g:4960:4: enumLiteral_2= 'System_Executes'
                    {
                    enumLiteral_2=(Token)match(input,160,FOLLOW_2); 

                    				current = grammarAccess.getStepOperationTypeAccess().getSystem_ExecutesEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getStepOperationTypeAccess().getSystem_ExecutesEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalRsl.g:4967:3: (enumLiteral_3= 'System_ReturnResult' )
                    {
                    // InternalRsl.g:4967:3: (enumLiteral_3= 'System_ReturnResult' )
                    // InternalRsl.g:4968:4: enumLiteral_3= 'System_ReturnResult'
                    {
                    enumLiteral_3=(Token)match(input,161,FOLLOW_2); 

                    				current = grammarAccess.getStepOperationTypeAccess().getSystem_ReturnResultEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getStepOperationTypeAccess().getSystem_ReturnResultEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalRsl.g:4975:3: (enumLiteral_4= 'Other' )
                    {
                    // InternalRsl.g:4975:3: (enumLiteral_4= 'Other' )
                    // InternalRsl.g:4976:4: enumLiteral_4= 'Other'
                    {
                    enumLiteral_4=(Token)match(input,93,FOLLOW_2); 

                    				current = grammarAccess.getStepOperationTypeAccess().getOtherEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getStepOperationTypeAccess().getOtherEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalRsl.g:4983:3: (enumLiteral_5= 'None' )
                    {
                    // InternalRsl.g:4983:3: (enumLiteral_5= 'None' )
                    // InternalRsl.g:4984:4: enumLiteral_5= 'None'
                    {
                    enumLiteral_5=(Token)match(input,162,FOLLOW_2); 

                    				current = grammarAccess.getStepOperationTypeAccess().getNoneEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getStepOperationTypeAccess().getNoneEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStepOperationType"


    // $ANTLR start "ruleStepOperationSubType"
    // InternalRsl.g:4994:1: ruleStepOperationSubType returns [Enumerator current=null] : ( (enumLiteral_0= 'SubmitData' ) | (enumLiteral_1= 'ShowData' ) | (enumLiteral_2= 'CancelUseCase' ) | (enumLiteral_3= 'TerminateUseCase' ) | (enumLiteral_4= 'Other' ) ) ;
    public final Enumerator ruleStepOperationSubType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;


        	enterRule();

        try {
            // InternalRsl.g:5000:2: ( ( (enumLiteral_0= 'SubmitData' ) | (enumLiteral_1= 'ShowData' ) | (enumLiteral_2= 'CancelUseCase' ) | (enumLiteral_3= 'TerminateUseCase' ) | (enumLiteral_4= 'Other' ) ) )
            // InternalRsl.g:5001:2: ( (enumLiteral_0= 'SubmitData' ) | (enumLiteral_1= 'ShowData' ) | (enumLiteral_2= 'CancelUseCase' ) | (enumLiteral_3= 'TerminateUseCase' ) | (enumLiteral_4= 'Other' ) )
            {
            // InternalRsl.g:5001:2: ( (enumLiteral_0= 'SubmitData' ) | (enumLiteral_1= 'ShowData' ) | (enumLiteral_2= 'CancelUseCase' ) | (enumLiteral_3= 'TerminateUseCase' ) | (enumLiteral_4= 'Other' ) )
            int alt96=5;
            switch ( input.LA(1) ) {
            case 163:
                {
                alt96=1;
                }
                break;
            case 164:
                {
                alt96=2;
                }
                break;
            case 165:
                {
                alt96=3;
                }
                break;
            case 166:
                {
                alt96=4;
                }
                break;
            case 93:
                {
                alt96=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 96, 0, input);

                throw nvae;
            }

            switch (alt96) {
                case 1 :
                    // InternalRsl.g:5002:3: (enumLiteral_0= 'SubmitData' )
                    {
                    // InternalRsl.g:5002:3: (enumLiteral_0= 'SubmitData' )
                    // InternalRsl.g:5003:4: enumLiteral_0= 'SubmitData'
                    {
                    enumLiteral_0=(Token)match(input,163,FOLLOW_2); 

                    				current = grammarAccess.getStepOperationSubTypeAccess().getSubmitDataEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getStepOperationSubTypeAccess().getSubmitDataEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalRsl.g:5010:3: (enumLiteral_1= 'ShowData' )
                    {
                    // InternalRsl.g:5010:3: (enumLiteral_1= 'ShowData' )
                    // InternalRsl.g:5011:4: enumLiteral_1= 'ShowData'
                    {
                    enumLiteral_1=(Token)match(input,164,FOLLOW_2); 

                    				current = grammarAccess.getStepOperationSubTypeAccess().getShowDataEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getStepOperationSubTypeAccess().getShowDataEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalRsl.g:5018:3: (enumLiteral_2= 'CancelUseCase' )
                    {
                    // InternalRsl.g:5018:3: (enumLiteral_2= 'CancelUseCase' )
                    // InternalRsl.g:5019:4: enumLiteral_2= 'CancelUseCase'
                    {
                    enumLiteral_2=(Token)match(input,165,FOLLOW_2); 

                    				current = grammarAccess.getStepOperationSubTypeAccess().getCancelUseCaseEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getStepOperationSubTypeAccess().getCancelUseCaseEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalRsl.g:5026:3: (enumLiteral_3= 'TerminateUseCase' )
                    {
                    // InternalRsl.g:5026:3: (enumLiteral_3= 'TerminateUseCase' )
                    // InternalRsl.g:5027:4: enumLiteral_3= 'TerminateUseCase'
                    {
                    enumLiteral_3=(Token)match(input,166,FOLLOW_2); 

                    				current = grammarAccess.getStepOperationSubTypeAccess().getTerminateUseCaseEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getStepOperationSubTypeAccess().getTerminateUseCaseEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalRsl.g:5034:3: (enumLiteral_4= 'Other' )
                    {
                    // InternalRsl.g:5034:3: (enumLiteral_4= 'Other' )
                    // InternalRsl.g:5035:4: enumLiteral_4= 'Other'
                    {
                    enumLiteral_4=(Token)match(input,93,FOLLOW_2); 

                    				current = grammarAccess.getStepOperationSubTypeAccess().getOtherEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getStepOperationSubTypeAccess().getOtherEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStepOperationSubType"


    // $ANTLR start "ruleStateMachineType"
    // InternalRsl.g:5045:1: ruleStateMachineType returns [Enumerator current=null] : ( (enumLiteral_0= 'Simple' ) | (enumLiteral_1= 'Complex' ) ) ;
    public final Enumerator ruleStateMachineType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalRsl.g:5051:2: ( ( (enumLiteral_0= 'Simple' ) | (enumLiteral_1= 'Complex' ) ) )
            // InternalRsl.g:5052:2: ( (enumLiteral_0= 'Simple' ) | (enumLiteral_1= 'Complex' ) )
            {
            // InternalRsl.g:5052:2: ( (enumLiteral_0= 'Simple' ) | (enumLiteral_1= 'Complex' ) )
            int alt97=2;
            int LA97_0 = input.LA(1);

            if ( (LA97_0==109) ) {
                alt97=1;
            }
            else if ( (LA97_0==110) ) {
                alt97=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 97, 0, input);

                throw nvae;
            }
            switch (alt97) {
                case 1 :
                    // InternalRsl.g:5053:3: (enumLiteral_0= 'Simple' )
                    {
                    // InternalRsl.g:5053:3: (enumLiteral_0= 'Simple' )
                    // InternalRsl.g:5054:4: enumLiteral_0= 'Simple'
                    {
                    enumLiteral_0=(Token)match(input,109,FOLLOW_2); 

                    				current = grammarAccess.getStateMachineTypeAccess().getSimpleEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getStateMachineTypeAccess().getSimpleEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalRsl.g:5061:3: (enumLiteral_1= 'Complex' )
                    {
                    // InternalRsl.g:5061:3: (enumLiteral_1= 'Complex' )
                    // InternalRsl.g:5062:4: enumLiteral_1= 'Complex'
                    {
                    enumLiteral_1=(Token)match(input,110,FOLLOW_2); 

                    				current = grammarAccess.getStateMachineTypeAccess().getComplexEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getStateMachineTypeAccess().getComplexEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStateMachineType"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000010004000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x9880004000000002L,0x0000000000020000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x9880000000000002L,0x0000000000020000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x9800000000000002L,0x0000000000020000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x9000000000000002L,0x0000000000020000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x1000000000000002L,0x0000000000020000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x1000000000000002L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000000L,0x000000003E000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000001E00000000L,0x00000000C0000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000001E00000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000001C00000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000001800000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000000000L,0x0000180000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000000000L,0x0000600000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000018000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0070019800000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0060001800000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0040001800000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000000000L,0x7FFF800000000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000020040000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000F81800000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x000F000000000080L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000F01800000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000E01800000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000C01800000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000801800000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000000000L,0x8000600000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0600001800000000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0400001800000000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000007L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000009800000000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000000000L,0x0000003F20000000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L,0x0000000007FFFF80L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0080001800000000L,0x00000000000006FEL});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0080001800000000L,0x00000000000006FCL});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000001800000000L,0x00000000000006FCL});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000001800000000L,0x00000000000006F8L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000001800000000L,0x00000000000006F0L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000001800000000L,0x00000000000006D0L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000001800000000L,0x00000000000004D0L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000001800000000L,0x0000000000000490L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000078L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000001800000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000001000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000038000000L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0000001800000000L,0x0000000000004800L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000000000000000L,0x0000000000003000L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000001800000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000001000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L,0x00000007C0000000L});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L,0x0000007800000000L});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x0000001000000080L,0x0000000000014000L});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x0000001000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x0800000800000002L,0x000000000000800CL});
    public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x0000000800000002L,0x000000000000800CL});
    public static final BitSet FOLLOW_81 = new BitSet(new long[]{0x0000000000000002L,0x000000000000800CL});
    public static final BitSet FOLLOW_82 = new BitSet(new long[]{0x0000000000000002L,0x0000000000008008L});
    public static final BitSet FOLLOW_83 = new BitSet(new long[]{0x0000000000000002L,0x0000000000008000L});
    public static final BitSet FOLLOW_84 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_85 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_86 = new BitSet(new long[]{0x0000001800000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_87 = new BitSet(new long[]{0x0000001000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_88 = new BitSet(new long[]{0x0000000000000002L,0x0000000000040000L});
    public static final BitSet FOLLOW_89 = new BitSet(new long[]{0x0000000020000002L,0x0000000000F80000L});
    public static final BitSet FOLLOW_90 = new BitSet(new long[]{0x0000000020000002L,0x0000000000F00000L});
    public static final BitSet FOLLOW_91 = new BitSet(new long[]{0x0000000020000002L,0x0000000000E00000L});
    public static final BitSet FOLLOW_92 = new BitSet(new long[]{0x0000000020000002L,0x0000000000C00000L});
    public static final BitSet FOLLOW_93 = new BitSet(new long[]{0x0000000020000002L,0x0000000000800000L});
    public static final BitSet FOLLOW_94 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_95 = new BitSet(new long[]{0x0000000000000002L,0x0000000000800000L});
    public static final BitSet FOLLOW_96 = new BitSet(new long[]{0x0000000000000002L,0x0000000001000000L});

}