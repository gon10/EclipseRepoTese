using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Threading.Tasks;
using Newtonsoft.Json;

namespace OpenGameListWebApp.ViewModels
{
    [JsonObject(MemberSerialization.OptOut)]
    public class E_Invoice
    {
        #region Constructor
        public E_Invoice()
        {

        }
        #endregion Constructor

        #region Properties
        public int ID { get; set; }
        public int CustomerID { get; set; }
        public DateTime DateCreation { get; set; }
        public DateTime DateApproval { get; set; }
        public DateTime DatePaid { get; set; }
        public DateTime DateDeleted { get; set; }
        public Boolean IsApproved { get; set; }
        public Decimal TotalValueWithoutVAT { get; set; }
        public Decimal TotalValueWithVAT { get; set; }
        #endregion Properties
    }    
}
