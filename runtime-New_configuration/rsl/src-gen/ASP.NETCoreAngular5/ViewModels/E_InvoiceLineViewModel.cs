using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Threading.Tasks;
using Newtonsoft.Json;

namespace OpenGameListWebApp.ViewModels
{
    [JsonObject(MemberSerialization.OptOut)]
    public class E_InvoiceLine
    {
        #region Constructor
        public E_InvoiceLine()
        {

        }
        #endregion Constructor

        #region Properties
        public int ID { get; set; }
        public int InvoiceID { get; set; }
        public int ProductID { get; set; }
        public Decimal ValueWithoutVAT { get; set; }
        public Decimal ValueWithVAT { get; set; }
        #endregion Properties
    }    
}
