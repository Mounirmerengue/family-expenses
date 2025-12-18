# 💰 Family Expenses Manager

Application de gestion des dépenses familiales avec backend Spring Boot et frontend Angular.

## 🚀 Technologies

- **Backend**: Java 17 + Spring Boot 3.2
- **Frontend**: Angular 17 + Chart.js
- **Base de données**: PostgreSQL 15
- **Conteneurisation**: Docker + Docker Compose

## 📦 Prérequis

- Docker Desktop
- Git

## 🏃 Démarrage rapide
```bash
# Cloner le projet
git clone https://github.com/Mounirmerengue/family-expenses.git
cd family-expenses

# Lancer tous les services
docker-compose up --build
```

L'application sera accessible sur:
- **Frontend**: http://localhost:4200
- **Backend API**: http://localhost:8080/api/expenses
- **Base de données**: localhost:5432

## 🛑 Arrêter les services
```bash
docker-compose down

# Pour supprimer aussi les volumes (données)
docker-compose down -v
```

## 📊 Fonctionnalités

- ✅ Ajouter/Modifier/Supprimer des dépenses
- ✅ Catégorisation des dépenses
- ✅ Attribution par membre de famille
- ✅ Filtres par date et catégorie
- ✅ Calcul des totaux

## 🔌 API Endpoints

| Méthode | Endpoint | Description |
|---------|----------|-------------|
| GET | `/api/expenses` | Liste toutes les dépenses |
| POST | `/api/expenses` | Créer une dépense |
| PUT | `/api/expenses/{id}` | Modifier une dépense |
| DELETE | `/api/expenses/{id}` | Supprimer une dépense |
| GET | `/api/expenses/stats/category` | Statistiques par catégorie |
| GET | `/api/expenses/stats/member` | Statistiques par membre |

## 📝 License

MIT