package org.rslingo.rsl.generator.Angular5andASP.NET_Core.DAL;

import java.util.ArrayList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.rslingo.rsl.rsl.DataEntity;

@SuppressWarnings("all")
public class AppDbContext {
  private ArrayList<DataEntity> entities = new ArrayList<DataEntity>();
  
  private ArrayList<String> oneToMany1 = new ArrayList<String>();
  
  private ArrayList<String> oneToMany2 = new ArrayList<String>();
  
  private ArrayList<String> oneToOne1 = new ArrayList<String>();
  
  private ArrayList<String> oneToOne2 = new ArrayList<String>();
  
  private ArrayList<String> ManyToMany1 = new ArrayList<String>();
  
  private ArrayList<String> ManyToMany2 = new ArrayList<String>();
  
  public AppDbContext(final ArrayList<DataEntity> entities, final ArrayList<String> onetoone1, final ArrayList<String> onetoone2, final ArrayList<String> onetomany1, final ArrayList<String> onetomany2) {
    this.entities = entities;
    this.oneToMany1 = onetomany1;
    this.oneToMany2 = onetomany2;
    this.oneToOne1 = onetoone1;
    this.oneToOne2 = onetoone2;
    this.ManyToMany1 = this.ManyToMany1;
    this.ManyToMany2 = this.ManyToMany2;
  }
  
  public CharSequence genAppDbContext() {
    CharSequence _xblockexpression = null;
    {
      int ind = 0;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("// ====================================================");
      _builder.newLine();
      _builder.append("// More Templates: https://www.ebenmonney.com/templates");
      _builder.newLine();
      _builder.append("// Email: support@ebenmonney.com");
      _builder.newLine();
      _builder.append("// ====================================================");
      _builder.newLine();
      _builder.newLine();
      _builder.append("using DAL.Models;");
      _builder.newLine();
      _builder.append("using Microsoft.AspNetCore.Identity.EntityFrameworkCore;");
      _builder.newLine();
      _builder.append("using Microsoft.EntityFrameworkCore;");
      _builder.newLine();
      _builder.append("using System;");
      _builder.newLine();
      _builder.append("using System.Collections.Generic;");
      _builder.newLine();
      _builder.append("using System.Linq;");
      _builder.newLine();
      _builder.append("using System.Text;");
      _builder.newLine();
      _builder.append("using System.Threading.Tasks;");
      _builder.newLine();
      _builder.append("using System.Threading;");
      _builder.newLine();
      _builder.append("using DAL.Models.Interfaces;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("namespace DAL");
      _builder.newLine();
      _builder.append("{");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("public class ApplicationDbContext : IdentityDbContext<ApplicationUser, ApplicationRole, string>");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("{");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("public string CurrentUserId { get; set; }");
      _builder.newLine();
      _builder.append("        ");
      _builder.newLine();
      _builder.append("        ");
      ArrayList<String> entitiesTreated = new ArrayList<String>();
      _builder.newLineIfNotEmpty();
      {
        for(final DataEntity entity : this.entities) {
          {
            String _name = entity.getName();
            boolean _contains = entitiesTreated.contains(_name);
            boolean _not = (!_contains);
            if (_not) {
              _builder.append("        ");
              _builder.append("public DbSet<");
              String _name_1 = entity.getName();
              _builder.append(_name_1, "        ");
              _builder.append("> ");
              String _name_2 = entity.getName();
              _builder.append(_name_2, "        ");
              _builder.append("s { get; set; }");
              _builder.newLineIfNotEmpty();
              _builder.append("        ");
              String _xblockexpression_1 = null;
              {
                String _name_3 = entity.getName();
                entitiesTreated.add(_name_3);
                _xblockexpression_1 = "";
              }
              _builder.append(_xblockexpression_1, "        ");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder.newLine();
      _builder.newLine();
      _builder.newLine();
      _builder.append("        ");
      _builder.append("public ApplicationDbContext(DbContextOptions options) : base(options)");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("{ }");
      _builder.newLine();
      _builder.newLine();
      _builder.newLine();
      _builder.append("        ");
      _builder.append("protected override void OnModelCreating(ModelBuilder builder)");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("{");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("base.OnModelCreating(builder);");
      _builder.newLine();
      _builder.newLine();
      _builder.append("            ");
      _builder.append("builder.Entity<ApplicationUser>().HasMany(u => u.Claims).WithOne().HasForeignKey(c => c.UserId).IsRequired().OnDelete(DeleteBehavior.Cascade);");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("builder.Entity<ApplicationUser>().HasMany(u => u.Roles).WithOne().HasForeignKey(r => r.UserId).IsRequired().OnDelete(DeleteBehavior.Cascade);");
      _builder.newLine();
      _builder.newLine();
      _builder.append("            ");
      _builder.append("builder.Entity<ApplicationRole>().HasMany(r => r.Claims).WithOne().HasForeignKey(c => c.RoleId).IsRequired().OnDelete(DeleteBehavior.Cascade);");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("builder.Entity<ApplicationRole>().HasMany(r => r.Users).WithOne().HasForeignKey(r => r.RoleId).IsRequired().OnDelete(DeleteBehavior.Cascade);");
      _builder.newLine();
      _builder.append("            ");
      _builder.newLine();
      _builder.append("\t\t\t");
      ArrayList<String> entitiesTreatedForBuilder = new ArrayList<String>();
      _builder.newLineIfNotEmpty();
      {
        for(final DataEntity entity_1 : this.entities) {
          {
            String _name_3 = entity_1.getName();
            boolean _contains_1 = entitiesTreatedForBuilder.contains(_name_3);
            boolean _not_1 = (!_contains_1);
            if (_not_1) {
              _builder.append("        \t");
              _builder.append("builder.Entity<");
              String _name_4 = entity_1.getName();
              _builder.append(_name_4, "        \t");
              _builder.append(">().ToTable($\"App{nameof(this.");
              String _name_5 = entity_1.getName();
              _builder.append(_name_5, "        \t");
              _builder.append("s)}\");");
              _builder.newLineIfNotEmpty();
              _builder.append("        \t");
              String _xblockexpression_2 = null;
              {
                String _name_6 = entity_1.getName();
                entitiesTreatedForBuilder.add(_name_6);
                _xblockexpression_2 = "";
              }
              _builder.append(_xblockexpression_2, "        \t");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder.append("        ");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.newLine();
      _builder.newLine();
      _builder.newLine();
      _builder.append("        ");
      _builder.append("public override int SaveChanges()");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("{");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("UpdateAuditEntities();");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("return base.SaveChanges();");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.newLine();
      _builder.append("        ");
      _builder.append("public override int SaveChanges(bool acceptAllChangesOnSuccess)");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("{");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("UpdateAuditEntities();");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("return base.SaveChanges(acceptAllChangesOnSuccess);");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.newLine();
      _builder.append("        ");
      _builder.append("public override Task<int> SaveChangesAsync(CancellationToken cancellationToken = default(CancellationToken))");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("{");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("UpdateAuditEntities();");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("return base.SaveChangesAsync(cancellationToken);");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.newLine();
      _builder.append("        ");
      _builder.append("public override Task<int> SaveChangesAsync(bool acceptAllChangesOnSuccess, CancellationToken cancellationToken = default(CancellationToken))");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("{");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("UpdateAuditEntities();");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("return base.SaveChangesAsync(acceptAllChangesOnSuccess, cancellationToken);");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.newLine();
      _builder.append("        ");
      _builder.append("private void UpdateAuditEntities()");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("{");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("var modifiedEntries = ChangeTracker.Entries()");
      _builder.newLine();
      _builder.append("                ");
      _builder.append(".Where(x => x.Entity is IAuditableEntity && (x.State == EntityState.Added || x.State == EntityState.Modified));");
      _builder.newLine();
      _builder.newLine();
      _builder.newLine();
      _builder.append("            ");
      _builder.append("foreach (var entry in modifiedEntries)");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("{");
      _builder.newLine();
      _builder.append("                ");
      _builder.append("var entity = (IAuditableEntity)entry.Entity;");
      _builder.newLine();
      _builder.append("                ");
      _builder.append("DateTime now = DateTime.UtcNow;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("                ");
      _builder.append("if (entry.State == EntityState.Added)");
      _builder.newLine();
      _builder.append("                ");
      _builder.append("{");
      _builder.newLine();
      _builder.append("                    ");
      _builder.append("entity.CreatedDate = now;");
      _builder.newLine();
      _builder.append("                    ");
      _builder.append("entity.CreatedBy = CurrentUserId;");
      _builder.newLine();
      _builder.append("                ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("                ");
      _builder.append("else");
      _builder.newLine();
      _builder.append("                ");
      _builder.append("{");
      _builder.newLine();
      _builder.append("                    ");
      _builder.append("base.Entry(entity).Property(x => x.CreatedBy).IsModified = false;");
      _builder.newLine();
      _builder.append("                    ");
      _builder.append("base.Entry(entity).Property(x => x.CreatedDate).IsModified = false;");
      _builder.newLine();
      _builder.append("                ");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("                ");
      _builder.append("entity.UpdatedDate = now;");
      _builder.newLine();
      _builder.append("                ");
      _builder.append("entity.UpdatedBy = CurrentUserId;");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
}
