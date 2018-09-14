using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Threading.Tasks;
using Newtonsoft.Json;

namespace OpenGameListWebApp.ViewModels
{
    [JsonObject(MemberSerialization.OptOut)]
    public class E_VAT
    {
        #region Constructor
        public E_VAT()
        {

        }
        #endregion Constructor

        #region Properties
        public int VATCode { get; set; }
        public String VATName { get; set; }
        public Decimal VATValue { get; set; }
        #endregion Properties
    }    
}
