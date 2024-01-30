using MaesEmAcao_api.Models;
using Microsoft.EntityFrameworkCore;

namespace MaesEmAcao_api.Context
{
    public class DataContext : DbContext
    {
        public DataContext(DbContextOptions<DataContext> options) : base(options) { }
        public DbSet<Vaga> Vagas { get; set; }
        public DbSet<Candidato> Candidatos { get; set; }
        public DbSet<Experiencia> Experiencias { get; set; }
        public DbSet<Empresa> Empresas { get; set; }
    }
}
