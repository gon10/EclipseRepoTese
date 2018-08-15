using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Threading.Tasks;
using Newtonsoft.Json;

namespace OpenGameListWebApp.ViewModels
{
    [JsonObject(MemberSerialization.OptOut)]
    public class E_Customer
    {
        #region Constructor
        public E_Customer()
        {

        }
        #endregion Constructor

        #region Properties
        public int ID { get; set; }
        public String Name { get; set; }
        public String FiscalID { get; set; }
        #endregion Properties
    }    
}
