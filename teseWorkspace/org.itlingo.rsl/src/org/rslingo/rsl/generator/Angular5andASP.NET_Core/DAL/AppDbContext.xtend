package org.rslingo.rsl.generator.Angular5andASP.NET_Core.DAL

import java.util.ArrayList
import org.rslingo.rsl.rsl.DataEntity

class AppDbContext {
	
	ArrayList<DataEntity> entities = new ArrayList();
	
	ArrayList<String> oneToMany1 = new ArrayList<String>();
	ArrayList<String> oneToMany2 = new ArrayList<String>();
	
	ArrayList<String> oneToOne1 = new ArrayList<String>();
	ArrayList<String> oneToOne2 = new ArrayList<String>();
	
	ArrayList<String> ManyToMany1 = new ArrayList<String>();
	ArrayList<String> ManyToMany2 = new ArrayList<String>();
	
	new(ArrayList<DataEntity> entities, ArrayList<String> onetoone1, ArrayList<String> onetoone2,
		 ArrayList<String> onetomany1, ArrayList<String> onetomany2) {
		this.entities = entities;
		this.oneToMany1 = onetomany1;
		this.oneToMany2 = onetomany2;
		this.oneToOne1 = onetoone1;
		this.oneToOne2 = onetoone2;
		this.ManyToMany1 = ManyToMany1;
		this.ManyToMany2 = ManyToMany2;
	}
	
	def genAppDbContext(){
		var ind = 0;			
		'''
		// ====================================================
		// More Templates: https://www.ebenmonney.com/templates
		// Email: support@ebenmonney.com
		// ====================================================
		
		using DAL.Models;
		using Microsoft.AspNetCore.Identity.EntityFrameworkCore;
		using Microsoft.EntityFrameworkCore;
		using System;
		using System.Collections.Generic;
		using System.Linq;
		using System.Text;
		using System.Threading.Tasks;
		using System.Threading;
		using DAL.Models.Interfaces;
		
		namespace DAL
		{
		    public class ApplicationDbContext : IdentityDbContext<ApplicationUser, ApplicationRole, string>
		    {
		        public string CurrentUserId { get; set; }
		        
		        �var entitiesTreated = new ArrayList<String>�
		        �FOR entity: entities�
		        �IF !entitiesTreated.contains(entity.name)�
		        public DbSet<�entity.name�> �entity.name�s { get; set; }
		        �{entitiesTreated.add(entity.name); ""}�
		        �ENDIF�
		        �ENDFOR�
		
		
		
		        public ApplicationDbContext(DbContextOptions options) : base(options)
		        { }
		
		
		        protected override void OnModelCreating(ModelBuilder builder)
		        {
		            base.OnModelCreating(builder);
		
		            builder.Entity<ApplicationUser>().HasMany(u => u.Claims).WithOne().HasForeignKey(c => c.UserId).IsRequired().OnDelete(DeleteBehavior.Cascade);
		            builder.Entity<ApplicationUser>().HasMany(u => u.Roles).WithOne().HasForeignKey(r => r.UserId).IsRequired().OnDelete(DeleteBehavior.Cascade);
		
		            builder.Entity<ApplicationRole>().HasMany(r => r.Claims).WithOne().HasForeignKey(c => c.RoleId).IsRequired().OnDelete(DeleteBehavior.Cascade);
		            builder.Entity<ApplicationRole>().HasMany(r => r.Users).WithOne().HasForeignKey(r => r.RoleId).IsRequired().OnDelete(DeleteBehavior.Cascade);
		            
					�var entitiesTreatedForBuilder = new ArrayList<String>�
		        	�FOR entity: entities�
		        	�IF !entitiesTreatedForBuilder.contains(entity.name)�
		        	builder.Entity<�entity.name�>().ToTable($"App{nameof(this.�entity.name�s)}");
		        	�{entitiesTreatedForBuilder.add(entity.name); ""}�
		        	�ENDIF�
					�ENDFOR�
		        }
		
		
		
		
		        public override int SaveChanges()
		        {
		            UpdateAuditEntities();
		            return base.SaveChanges();
		        }
		
		
		        public override int SaveChanges(bool acceptAllChangesOnSuccess)
		        {
		            UpdateAuditEntities();
		            return base.SaveChanges(acceptAllChangesOnSuccess);
		        }
		
		
		        public override Task<int> SaveChangesAsync(CancellationToken cancellationToken = default(CancellationToken))
		        {
		            UpdateAuditEntities();
		            return base.SaveChangesAsync(cancellationToken);
		        }
		
		
		        public override Task<int> SaveChangesAsync(bool acceptAllChangesOnSuccess, CancellationToken cancellationToken = default(CancellationToken))
		        {
		            UpdateAuditEntities();
		            return base.SaveChangesAsync(acceptAllChangesOnSuccess, cancellationToken);
		        }
		
		
		        private void UpdateAuditEntities()
		        {
		            var modifiedEntries = ChangeTracker.Entries()
		                .Where(x => x.Entity is IAuditableEntity && (x.State == EntityState.Added || x.State == EntityState.Modified));
		
		
		            foreach (var entry in modifiedEntries)
		            {
		                var entity = (IAuditableEntity)entry.Entity;
		                DateTime now = DateTime.UtcNow;
		
		                if (entry.State == EntityState.Added)
		                {
		                    entity.CreatedDate = now;
		                    entity.CreatedBy = CurrentUserId;
		                }
		                else
		                {
		                    base.Entry(entity).Property(x => x.CreatedBy).IsModified = false;
		                    base.Entry(entity).Property(x => x.CreatedDate).IsModified = false;
		                }
		
		                entity.UpdatedDate = now;
		                entity.UpdatedBy = CurrentUserId;
		            }
		        }
		    }
		}
���		
���		
���		
���		
���		using Microsoft.AspNetCore.Identity.EntityFrameworkCore;
���		using Microsoft.EntityFrameworkCore;
���		using Microsoft.EntityFrameworkCore.Metadata;
���		
���		�FOR ent : entities�
���		using OpenGameListWebApp.Data.�ent.name�s;
���		�ENDFOR�
���		
���		namespace OpenGameListWebApp.Data
���		{
���		    public class ApplicationDbContext : DbContext
���		    {
���		        #region Constructor
���		        public ApplicationDbContext(DbContextOptions options) : base(options)
���		        {
���		        }
���		        #endregion Constructor
���		
���		        #region Methods
���		        protected override void OnModelCreating(ModelBuilder modelBuilder)
���		        {
���		            base.OnModelCreating(modelBuilder);
���		            
���		           	�FOR ent : entities�
���		           	modelBuilder.Entity<�ent.name�>().ToTable("�ent.name�s");
���		           	�FOR otm1 : oneToMany1�
���		           	�IF otm1 == ent.name�modelBuilder.Entity<�ent.name�>().HasOne(a => a.�oneToMany2.get(ind)�RP).WithMany(b => b.�ent.name�sRP);�ENDIF�
���		           	�{ind = ind +1; ""}� 
���		           	�ENDFOR�
���		           	�{ind = 0; ""}�
���		           	�FOR otm2 : oneToMany2�
���		           	�IF otm2 == ent.name�modelBuilder.Entity<�ent.name�>().HasMany(a => a.�oneToMany1.get(ind)�sRP).WithOne(b => b.�ent.name�RP);�ENDIF�
���		           	�{ind = ind + 1; ""}�
���		           	�ENDFOR�
���		           	
���		           	�{ind = 0; ""}�
���		           	�FOR oto1 : oneToOne1�
���		           	�IF oto1 == ent.name�modelBuilder.Entity<�ent.name�>().HasOne(a => a.�oneToOne2.get(ind)�RP).WithOne(b => b.�ent.name�RP);�ENDIF�
���		           	�{ind = ind + 1; ""}�
���		           	�ENDFOR�
���		           	�{ind = 0; ""}�
���		           	�FOR oto2 : oneToOne2�
���		           	�IF oto2 == ent.name�modelBuilder.Entity<�ent.name�>().HasOne(a => a.�oneToOne1.get(ind)�RP).WithOne(b => b.�ent.name�RP);�ENDIF�
���		           	�{ind = ind + 1; ""}�
���		           	�ENDFOR�
���		           	
���		           	�{ind = 0; ""}�
���		           	�ENDFOR�
���		        }
���		        #endregion Methods
���		        
���		        #region Properties
���		        �FOR ent : entities�
���		        public DbSet<�ent.name�> �ent.name�s { get; set; }
���		        �ENDFOR�
���		        #endregion Properties
���		    }
���		}
		'''
	}
	
}
